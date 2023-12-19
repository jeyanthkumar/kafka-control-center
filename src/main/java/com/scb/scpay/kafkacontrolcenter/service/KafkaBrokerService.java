package com.scb.scpay.kafkacontrolcenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.scb.scpay.kafkacontrolcenter.configuration.ConsumerConfiguration;
import com.scb.scpay.kafkacontrolcenter.model.KafkaBrokerMetaInfo;

@Service
public class KafkaBrokerService {

	@Autowired
	ConsumerConfiguration consumerConfiguration;

	public List<KafkaBrokerMetaInfo> getKafkaBrokerInfo(KafkaTemplate<String, String> template){
		List<KafkaBrokerMetaInfo> result = new ArrayList<KafkaBrokerMetaInfo>();
		Consumer<String, String> consumer = consumerConfiguration.consumerFactory().createConsumer();

		System.out.println("----->>>>>> List of Topics ----------->>>>>>>>>>>>>"+consumer.listTopics());
		Map<String, List<PartitionInfo>> listOfTopicMap = consumer.listTopics();

		for(String topic:listOfTopicMap.keySet()) {

//			String topicName = "test-topic";
			List<PartitionInfo> partitionInfoList = listOfTopicMap.get(topic);
//			List<PartitionInfo> partitionInfoList = template.partitionsFor(topicName);

			KafkaBrokerMetaInfo brokerMetaInfo =  new KafkaBrokerMetaInfo();
			brokerMetaInfo.setTopicName(topic);
			brokerMetaInfo.setNoOfPartition(partitionInfoList.size());
			System.out.println("partitionInfoList.get(0).replicas(). "+partitionInfoList.get(0).replicas().toString());
			brokerMetaInfo.setNoOfReplica(partitionInfoList.get(0).replicas().length);
			brokerMetaInfo.setNoOfInsyncReplica(partitionInfoList.get(0).inSyncReplicas().length);

			result.add(brokerMetaInfo);
			System.out.println(brokerMetaInfo.toString());

			//	    	for(PartitionInfo part:partitionInfoList) {
			//    		brokerMetaInfo.setTopicName(part.topic());
			//    		
			//    	}
		}




		return result;
	}
}

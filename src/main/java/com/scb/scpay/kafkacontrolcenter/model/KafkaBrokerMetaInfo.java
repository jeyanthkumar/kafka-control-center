package com.scb.scpay.kafkacontrolcenter.model;


public class KafkaBrokerMetaInfo {

	private String topicName;
	private Integer noOfPartition;
	private Integer noOfReplica;
	private Integer noOfInsyncReplica;
	private Integer msgTTL;
	private Integer messageSize;
	private Integer offset;
	private Integer noOfMessageUnread;
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Integer getNoOfPartition() {
		return noOfPartition;
	}
	public void setNoOfPartition(Integer noOfPartition) {
		this.noOfPartition = noOfPartition;
	}
	public Integer getNoOfReplica() {
		return noOfReplica;
	}
	public void setNoOfReplica(Integer noOfReplica) {
		this.noOfReplica = noOfReplica;
	}
	public Integer getNoOfInsyncReplica() {
		return noOfInsyncReplica;
	}
	public void setNoOfInsyncReplica(Integer noOfInsyncReplica) {
		this.noOfInsyncReplica = noOfInsyncReplica;
	}
	public Integer getMsgTTL() {
		return msgTTL;
	}
	public void setMsgTTL(Integer msgTTL) {
		this.msgTTL = msgTTL;
	}
	public Integer getMessageSize() {
		return messageSize;
	}
	public void setMessageSize(Integer messageSize) {
		this.messageSize = messageSize;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getNoOfMessageUnread() {
		return noOfMessageUnread;
	}
	public void setNoOfMessageUnread(Integer noOfMessageUnread) {
		this.noOfMessageUnread = noOfMessageUnread;
	}
	
	
}

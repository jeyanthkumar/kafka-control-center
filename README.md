# Create a Java Application With Apache Kafka

This example shows how to use Okta's Authentication API with Java integrating with Kafka.

Please read [Kafka with Java: Build a Secure, Scalable Messaging App][blog-url] for a tutorial that shows you how to build this application.

**Prerequisites:** 

* [Java 8+](https://adoptopenjdk.net/)
* [Kafka](https://kafka.apache.org/downloads)

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Help](#help)
* [Links](#links)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-java-kafka-example.git
```

This will get a copy of the project locally. 

### Create a Free Okta Developer Account

If you don't have one, [create an Okta Developer account](https://developer.okta.com/signup/). After you've completed the setup process, you'll need to log in and create a new application.

* Go to  **Applications** > **Add Application**
* Select **Web** and click **Next** 
* Fill in the following options in the form:
    - Name: Bootiful Kafka
    - Base URIs: `http://localhost:8080`
    - Login redirect URLs: `http://localhost:8080/login/oauth2/code/okta`
* Click **Done**

Copy and paste your client ID and secret into `src/main/resources/application.properties`.

```properties
okta.oauth2.issuer: https://{yourOktaDomain}/oauth2/default  
okta.oauth2.client-id: {yourClientID}
okta.oauth2.client-secret: {yourClientSecret}
```

The value for `{yourOktaDomain}` can be found in the top right corner of your Okta Dashboard, it will look something like: `https://dev-123456.okta.com`.

**IMPORTANT**: This file should only be used locally. Do not commit your client's secret to Git or any other Version Control System.

> To avoid accidentally exposing these credentials, you can also specify your Okta application's values as environment variables. Create an `okta.env` file in the root directory of your app with the following environment variables. Then run `source okta.env` before starting your app.
> 
> ```bash
> export OKTA_OAUTH2_ISSUER=https://{yourOktaDomain}/oauth2/default
> export OKTA_OAUTH2_CLIENT_ID={yourClientID}
> export OKTA_OAUTH2_CLIENT_SECRET={yourClientSecret}
> ```

### Start the application

To start the application you can run:

```bash
./mvnw spring-boot:run
```

Navigate to `http://localhost:8080` to authenticate with Okta! If you don't see a login screen, it's likely because you're already logged in. Try it in an incognito window to see the OAuth 2.0 code flow in action.

## Links

This example uses the following libraries provided by Okta:

* [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)

## Help

Please post any questions as comments on [this blog post][blog-url], or visit our [Okta Developer Forums](https://devforum.okta.com/). You can also email developers@okta.com if would like to create a support ticket.

## License

Apache 2.0, see [LICENSE](LICENSE).

[blog-url]: https://developer.okta.com/blog/2019/11/19/java-kafka

# Helicon Java Sample App
This repository contains the files required to run the Helicon Java Quickstart.

Helicon is a simple, scalable, robust, code-free and generic platform to enable and productise the next generation of "online modified", real-time event stream ML/AI models.

## Set up the project

Run `mvn clean install` to install the project and resolve the dependencies.

## Sample App
### Publish
This code is available at `src/main/java/io/radicalbit/helicon/publish/HeliconPublishApp.java`. This example will publish as payload a json object like:
```json
{
"temperature": 26,
"timestamp": 1632143723
}
```
to a specific stream
```java
private static String host = "<helicon-host>";
private static int port = 443;
private static String clientId = "<client-id>";
private static String clientSecret = "<client-secret>";
private static String tenant = "tenant-name";
private static String streamName = "<stream_name>";

public static void main(String[] args) {

    HeliconPublishClient heliconClient = new HeliconPublishClient(host, port, clientId, clientSecret, tenant);

String payload = "{\"temperature\": 26, \"timestamp\": " + System.currentTimeMillis() + "}";
heliconClient.write(streamName, payload);
}
```
### Subscribe
Same for subscription, the code is available at `src/main/java/io/radicalbit/helicon/subscribe/HeliconSubscribeApp.java`, and it is going to print the message defined above.
```java
private static String host = "<helicon-host>";
private static int port = 443;
private static String clientId = "<client-id>";
private static String clientSecret = "<client-secret>";
private static String tenant = "tenant-name";
private static String streamName = "<stream_name>";

public static void main(String[] args) {
        HeliconSubscribeClient heliconClient = new HeliconSubscribeClient(host, port, clientId, clientSecret, tenant);

        heliconClient.subscribe(streamName, System.out::println);
        }
```
To be able to read the data you are writing with the publishing client you need to subscribe to the same stream.
The message received will be parsed as a GRPC response object before being processed from the response' callback consumer, `println` in this specific case.
You can decide to handle messages in a more specific way, depending on the message you are expecting to read:
   * you can use `subscribeBinary(String streamName, Consumer<byte[]> callback)` to parse the message response as an array of byte.
   * you can use `subscribeString(String streamName, Consumer<String> callback)` to parse the message response as a UTF-8 string.
   * you can use `subscribeJson(String streamName, Consumer<JSONObject> callback` to parse the message response as a JSONObject from [JSON-java](https://github.com/stleary/JSON-java).

## How to Run the app

Running the `HeliconSubscribeApp` class with your IDE or from a terminal including the classpath of the downloaded jars (`java -classpath /path/to/jars src/main/java/io/radicalbit/helicon/publish/HeliconPublishApp`), you will start to receive messages as soon as they are written on the stream.

To publish 1 message you can run the `HeliconPublishApp` class in the same way you have done before for `HeliconSubscribeApp`, or, for multiple messages, you can wrap it in a loop.

You should see printed the response on the terminal.

## Change the API version

The main branch is always updated with the latest version of Helicon API.

If you need to use an old version of the Helicon's API, you can switch between the project version using `git checkout tag_version`.

You can refer to Helicon documentation for looking more in the depth over the version's features.

## Support
We're always happy to help with any other questions you might have! [Send us an email](mailto:support@radicalbit.io).
 
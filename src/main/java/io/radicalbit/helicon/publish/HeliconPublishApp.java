package io.radicalbit.helicon.publish;

import io.radicalbit.helicon.publish.client.HeliconPublishClient;

public class HeliconPublishApp {

    private static String host = "<helicon-host>";
    private static int port = 443;
    private static String clientId = "<client-id>";
    private static String clientSecret = "<client-secret>";
    private static String tenant = "<tenant-name>";
    private static String streamName = "<stream-name>";

    public static void main(String[] args) {

        HeliconPublishClient heliconClient = new HeliconPublishClient(host, port, clientId, clientSecret, tenant);

        String payload = "{\"temperature\": 26, \"timestamp\": " + System.currentTimeMillis() + "}";
        heliconClient.write(streamName, payload);
    }
}

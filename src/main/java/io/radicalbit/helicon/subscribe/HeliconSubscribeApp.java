package io.radicalbit.helicon.subscribe;

import io.radicalbit.helicon.subscribe.client.HeliconSubscribeClient;

public class HeliconSubscribeApp {

    private static String authorizationServer = "<authorization-server-url>";
    private static String grpcHost = "<grpc-host>";
    private static int grpcPort = 443;
    private static String clientId = "<client-id>";
    private static String clientSecret = "<client-secret>";
    private static String tenant = "<tenant-name>";
    private static String streamName = "<stream_name>";

    public static void main(String[] args) {
        HeliconSubscribeClient heliconClient = new HeliconSubscribeClient(authorizationServer, grpcHost, grpcPort, clientId, clientSecret, tenant);

        heliconClient.subscribe(streamName, System.out::println);
    }
}

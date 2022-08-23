package com.tcp.test.general;

import com.tcp.classes.clientSide.SimpleClient;
import com.tcp.classes.serverSide.SimpleServer;
import com.tcp.interfaces.serverSide.ServerInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.function.Consumer;

public class InterfaceTesting {

    public static void main(String[] args) throws IOException {

        SimpleServer server = new SimpleServer(ServerInterface.instantiateSocket(8080), new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println("Server: " + o);
            }
        });
        server.runServer(server.getConsumer());

//        SimpleClient client = new SimpleClient(8080, new Consumer() {
//            @Override
//            public void accept(Object o) {
//                System.out.println("Client: " + o);
//            }
//        });
//        client.runClient();
    }

    class Server {

        public static void main(String[] args) throws IOException {
            SimpleServer server = new SimpleServer(ServerInterface.instantiateSocket(8080), new Consumer() {
                @Override
                public void accept(Object o) {
                    System.out.println("Server: " + o);
                }
            });
            server.runServer(server.getConsumer());
        }

    }
    class Client {
//        public static void main(String[] args) throws IOException {
////            SimpleClient client = new SimpleClient(8080, new Consumer() {
////                @Override
////                public void accept(Object o) {
////                    System.out.println("Client: " + o);
////                }
////            });
//            client.runClient();
//        }
    }

}
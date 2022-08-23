package com.tcp.classes.serverSide;

import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.interfaces.general.HelperMethods;
import com.tcp.interfaces.serverSide.ServerInterface;
import lombok.Data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

@Data
public class SimpleServer implements ServerInterface {

    private ServerSocket socket;
    private Consumer consumer;
    private static String terminator = "terminate";

    /**
     * Creates a new server with the given port and consumer.
     *
     * @param serverSocket The server socket to use.
     * @param consumer     The consumer saved to the SimpleServer Object.
     */
    public SimpleServer(ServerSocket serverSocket, Consumer<SimpleDataPackage> consumer) {

        this.socket = serverSocket;
        this.consumer = consumer;

    }

    public void runServer() {

        while(true) {
            try {
                Socket clientSocket = socket.accept();
                System.out.println("Client connected" + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket, consumer)).start();
            }
            catch (Exception e) {

//                System.out.println("Server: " + e.getMessage());

            }
        }

    }

    @Override
    public void runServer(Consumer<SimpleDataPackage> consumer) throws IOException {

        while(true) {
            try {
                Socket clientSocket = socket.accept();
                System.out.println("Client connected" + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket, consumer)).start();
            }
            catch (Exception e) {

//                System.out.println("Server: " + e.getMessage());

            }
        }

    }



    @Data
    public static class ClientHandler implements Runnable {

        private final Socket clientSocket;
        private final Consumer consumer;

        /**
         * @param socket   The client socket.
         * @param consumer The consumer.
         */
        public ClientHandler(Socket socket, Consumer<SimpleDataPackage> consumer) {

            this.clientSocket = socket;
            this.consumer = consumer;

        }

        @Override
        public void run() {


            while (true) {
                SimpleDataPackage dataPackage = ServerInterface.receiveDataPacket(clientSocket);


                if (!dataPackage.getMessageHeader().equals(terminator)) {

                    consumer.accept(dataPackage);

                } else {
                    break;
                }
                if (dataPackage.getMessageHeader().equals("data")) {

                    consumer.accept(dataPackage);
                    ServerInterface.sendDataPacket(new SimpleDataPackage("data", "data"), clientSocket);

                }

            }
        }
    }
}

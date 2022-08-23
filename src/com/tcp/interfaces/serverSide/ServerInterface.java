package com.tcp.interfaces.serverSide;

import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.interfaces.general.DataTransferInterface;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public interface ServerInterface extends DataTransferInterface {

    /**
     * This method keeps the server running. The consumer is
     * used to let the server know what to do while the run method
     * is keeping the server alive.
     * @param consumer What needs to be done while the server is alive.
     */
    void runServer(Consumer<SimpleDataPackage> consumer) throws IOException;

    /**
     * This method simply instantiates a new serversocket on the specified port.
     * @param port The port on which the server socket will be instantiated.
     * @return  The server socket.
     * @throws IOException If an error occurs while instantiating the server socket.
     */
    static ServerSocket instantiateSocket(int port) throws IOException {

        return new ServerSocket(port);

    }

    /**
     * This method simply sends the data packet to the specified socket.
     * @param dataPacket The data packet to be sent.
     * @param socket The socket to which the data packet will be sent.
     * @throws IOException If an error occurs while sending the data packet.
     */
    static void sendDataPacket(SimpleDataPackage dataPacket, Socket socket)  {

        try {
            DataTransferInterface.sendDataPacket(dataPacket, socket);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method simply receives the data packet from the specified socket.
     * @param socket The socket from which the data packet will be received.
     * @return The data packet received.
     * @throws IOException If an error occurs while receiving the data packet.
     * @throws ClassNotFoundException If the data packet is not of the correct type.
     */
    static SimpleDataPackage receiveDataPacket(Socket socket) {
        try {
            return DataTransferInterface.receiveDataPacket(socket);
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

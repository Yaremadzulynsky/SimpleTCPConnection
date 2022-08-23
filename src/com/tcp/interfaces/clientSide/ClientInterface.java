package com.tcp.interfaces.clientSide;

import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.interfaces.general.DataTransferInterface;

import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public interface ClientInterface extends DataTransferInterface {

    /**
     * This method keeps the client running. The consumer is used to
     * let the client know what to do while the run method is keeping
     * thie client alive.
     * @param consumer What needs to be done while the client is alive.
     */
    void runClient();

    /**
     * This method simply instantiates a new socket on the specified port.
     * @param port The port on which the socket will be instantiated.
     * @return The socket.
     * @throws IOException If an error occurs while instantiating the socket.
     */
    static Socket instantiateSocket(int port) throws IOException, IOException {

        return new Socket("localhost", port);

    }

    /**
     * This method simply sends the data packet to the specified socket.
     * @param dataPacket The data packet to be sent.
     * @param socket The socket to which the data packet will be sent.
     * @throws IOException If an error occurs while sending the data packet.
     */
    static void sendDataPacket(SimpleDataPackage dataPacket, Socket socket) {

        try {
            DataTransferInterface.sendDataPacket(dataPacket, socket);
        } catch (IOException e) {
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
    static Object receiveDataPacket(Socket socket)  {
        try {
            return DataTransferInterface.receiveDataPacket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

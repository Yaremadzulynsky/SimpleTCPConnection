package com.tcp.interfaces.general;

import com.tcp.classes.dataPackaging.SimpleDataPackage;

import java.io.*;
import java.net.Socket;

public interface DataTransferInterface {

    /**
     * This method simply sends the data packet to the specified socket.
     * @param dataPacket The data packet to be sent.
     * @param socket The socket to which the data packet will be sent.
     * @throws IOException If an error occurs while sending the data packet.
     */
    static void sendDataPacket(SimpleDataPackage dataPacket, Socket socket) throws IOException {

        getObjectOutputStream(socket).writeObject(dataPacket);

    }

    /**
     * This method simply receives the data packet from the specified socket.
     * @param socket The socket from which the data packet will be received.
     * @return The data packet received.
     * @throws IOException If an error occurs while receiving the data packet.
     * @throws ClassNotFoundException If the data packet is not of the correct type.
     */
    static SimpleDataPackage receiveDataPacket(Socket socket) throws IOException, ClassNotFoundException {
        return (SimpleDataPackage) getObjectInputStream(socket).readObject();
    }

    /**
     *
     * @param socket The socket from which to create the object output stream.
     * @return The object output stream.
     * @throws IOException If an error occurs while creating the object output stream.
     */
    static ObjectOutputStream getObjectOutputStream(Socket socket) throws IOException {

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        return objectOutputStream;

    }

    /**
     *
     * @param socket The socket from which to create the object input stream.
     * @return The object input stream.
     * @throws IOException If an error occurs while creating the object input stream.
     */
    static ObjectInputStream getObjectInputStream(Socket socket) throws IOException {

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return objectInputStream;

    }

}

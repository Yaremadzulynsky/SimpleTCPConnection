package com.tcp.classes.clientSide;

import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.interfaces.clientSide.ClientInterface;
import com.tcp.interfaces.dataPackaging.SerializableSupplier;
import com.tcp.interfaces.general.HelperMethods;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Supplier;

@Data
public class SimpleClient implements ClientInterface {

    private Socket socket;
    private SerializableSupplier<SimpleDataPackage> supplier;
    private String terminator = "terminate";

    public SimpleClient(int port, SerializableSupplier<SimpleDataPackage> supplier) throws IOException {

        this.socket = ClientInterface.instantiateSocket(port);
        this.supplier = supplier;

    }

    public SimpleClient(Socket socket) {

        this.socket = socket;
        this.supplier = new SerializableSupplier<SimpleDataPackage>() {

            @Override
            public SimpleDataPackage get() {
                return new SimpleDataPackage<>("void header", null);
            }

        };

    }


    @Override
    public void runClient() {

        while (true) {

            ClientInterface.sendDataPacket(supplier.get(), socket);
            HelperMethods.waitMilliseconds(1000);

        }

    }

}

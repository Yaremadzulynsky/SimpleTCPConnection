package com.tcp.test.clientSide;

import com.tcp.classes.clientSide.SimpleClient;
import com.tcp.classes.dataPackaging.EncapsulateAction;
import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.interfaces.clientSide.ClientInterface;
import com.tcp.interfaces.dataPackaging.SerializableConsumer;
import com.tcp.interfaces.dataPackaging.SerializableSupplier;
import com.tcp.interfaces.general.HelperMethods;
import com.tcp.test.dataPackaging.ActionTest;

import java.io.IOException;


public class Client {


    public static void main(String[] args) throws IOException {

        SerializableSupplier<SimpleDataPackage> serializableSupplier = new SerializableSupplier<SimpleDataPackage>() {

            @Override
            public SimpleDataPackage get() {
                SimpleDataPackage<EncapsulateAction, ActionTest> methodDataPacket = new SimpleDataPackage<>(null, null);
                SimpleDataPackage<EncapsulateAction, ActionTest> dataPacket = methodDataPacket.createEncapsulatedAction(HelperMethods.getScanner().nextLine(), new SerializableConsumer<ActionTest>() {
                    @Override
                    public void accept(ActionTest actionTest) {

                        actionTest.test();

                    }
                });
                return dataPacket;
            }
        };

        SimpleClient client = new SimpleClient(8080, serializableSupplier);
        client.runClient();

    }

}

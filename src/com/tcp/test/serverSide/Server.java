package com.tcp.test.serverSide;

import com.tcp.classes.dataPackaging.EncapsulateAction;
import com.tcp.classes.dataPackaging.SimpleDataPackage;
import com.tcp.classes.serverSide.SimpleServer;
import com.tcp.interfaces.serverSide.ServerInterface;
import com.tcp.test.dataPackaging.ActionTest;

import java.io.IOException;
import java.util.function.Consumer;

public class Server {


    public static void main(String[] args) throws IOException {

        Consumer consumer = new Consumer<SimpleDataPackage>() {
            @Override
            public void accept(SimpleDataPackage simpleDataPackage) {

                EncapsulateAction<ActionTest> encapsulateAction = (EncapsulateAction<ActionTest>) simpleDataPackage.getDataLoad();
                encapsulateAction.getConsumer().accept(new ActionTest());
            }
        };

        SimpleServer server = new SimpleServer(ServerInterface.instantiateSocket(8080), consumer);
        server.runServer();
    }

}

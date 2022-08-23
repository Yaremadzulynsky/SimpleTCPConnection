package com.tcp.classes.dataPackaging;

import com.tcp.interfaces.dataPackaging.SerializableConsumer;
import lombok.Data;

import java.io.Serializable;

@Data
public class EncapsulateAction<T> implements Serializable{

    private SerializableConsumer<T> consumer;

    public EncapsulateAction(SerializableConsumer<T> consumer) {

        this.consumer = consumer;

    }

    public EncapsulateAction() {

        this.consumer = new SerializableConsumer<T>() {
            @Override
            public void accept(T t) {
                System.out.println("Client sent: " + t);
            }
        };

    }

    public void unwrap(T t) {

        consumer.accept(t);

    }

    public EncapsulateAction generateEncapsulatedAction(SerializableConsumer<T> consumer) {

        return new EncapsulateAction(consumer);

    }
}

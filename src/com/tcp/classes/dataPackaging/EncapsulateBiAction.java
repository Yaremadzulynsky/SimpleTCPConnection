package com.tcp.classes.dataPackaging;

import com.tcp.interfaces.dataPackaging.SerializableBiConsumer;
import com.tcp.interfaces.dataPackaging.SerializableConsumer;
import lombok.Data;

import java.io.Serializable;

@Data
public class EncapsulateBiAction<T, A> implements Serializable{

    private SerializableBiConsumer<T, A> consumer;


    public EncapsulateBiAction(SerializableBiConsumer<T, A> consumer) {

        this.consumer = consumer;

    }

    public EncapsulateBiAction() {

        this.consumer = new SerializableBiConsumer<T, A>() {
            @Override
            public void accept(T t, A a) {
                System.out.println("Client sent: " + t + " + " + a);
            }
        };

    }

    public void unwrap(T t, A a) {

        consumer.accept(t, a);

    }

    public EncapsulateBiAction generateEncapsulatedAction(SerializableBiConsumer<T, A> consumer) {

        return new EncapsulateBiAction(consumer);

    }
}

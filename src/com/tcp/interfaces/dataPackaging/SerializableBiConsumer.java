package com.tcp.interfaces.dataPackaging;

public interface SerializableBiConsumer<T, C> {

void accept(T t, C c);

}

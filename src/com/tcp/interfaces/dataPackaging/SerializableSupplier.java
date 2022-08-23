package com.tcp.interfaces.dataPackaging;

import java.io.Serializable;

public interface SerializableSupplier<T> extends Serializable {

    public T get();



}

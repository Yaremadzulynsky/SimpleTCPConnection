package com.tcp.interfaces.dataPackaging;

import java.io.Serializable;

public interface SerializableConsumer<T> extends Serializable {

 public void accept(T t);

}

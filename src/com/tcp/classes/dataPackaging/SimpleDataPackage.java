package com.tcp.classes.dataPackaging;

import com.tcp.interfaces.dataPackaging.DataPackageInterface;
import com.tcp.interfaces.dataPackaging.SerializableConsumer;
import com.tcp.interfaces.general.HelperMethods;
import com.tcp.test.dataPackaging.ActionTest;
import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleDataPackage<T, A> implements DataPackageInterface, Serializable {

    private T dataLoad;
    private String messageHeader = "void";

    /**
     * @param messageHeader The message header of the data package.
     * @param dataLoad      The data load of the data package.
     */
    public SimpleDataPackage(String messageHeader, T dataLoad) {

        this.messageHeader = messageHeader;
        this.dataLoad = dataLoad;

    }

    @Override
    public T getLoad() {
        return dataLoad;
    }

    @Override
    public void setLoad(Object load) {

        dataLoad = (T) load;

    }

    @Override
    public String getMessageHeader() {
        return messageHeader;
    }

    @Override
    public String setMessageHeader(String newHeader) {
        this.messageHeader = newHeader;
        return messageHeader;
    }

    public SimpleDataPackage createEncapsulatedAction(String messageHeader, SerializableConsumer<A> consumer) {

        EncapsulateAction<A> encapsulateAction = new EncapsulateAction<>(consumer);
        return new SimpleDataPackage(messageHeader, encapsulateAction);
    }
}

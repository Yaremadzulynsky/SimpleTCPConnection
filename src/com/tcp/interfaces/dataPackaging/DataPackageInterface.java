package com.tcp.interfaces.dataPackaging;

public interface DataPackageInterface {

    /**
     * This method gets the data load.
     * @return The data load.
     */
    Object getLoad();


    /**
     * This method sets the data load.
     */
    void setLoad(Object load);

    /**
     * This method gets the header for the
     * server stored in a public variable
     * within the class.
     * @return The current message header.
     */
    String getMessageHeader();

    /**
     * This method sets the header for the server
     * to identify different messages.
     * @param newHeader The package header for id.
     */
    String setMessageHeader(String newHeader);

}

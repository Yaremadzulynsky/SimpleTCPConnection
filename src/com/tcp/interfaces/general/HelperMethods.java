package com.tcp.interfaces.general;

import java.util.Scanner;

public interface HelperMethods {

    static void waitMilliseconds(long milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    static Scanner getScanner() {

    return new Scanner(System.in);


    }
}

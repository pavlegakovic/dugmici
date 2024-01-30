package com.example.demo;

import com.fazecast.jSerialComm.SerialPort;

public class Main {

    public static void main(String[] args) {
        System.out.println("test app");

        long timeStart = System.currentTimeMillis();
        var sp= SerialPort.getCommPort("demo");


    }
}

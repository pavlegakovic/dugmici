package com.example.demo;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class Main {

    public static void main(String[] args) {

        SerialPort serialPort = SerialPort.getCommPort("COM11");
        serialPort.setComPortParameters(9600,Byte.SIZE,SerialPort.ONE_STOP_BIT,SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING,0,0);

        try {
            serialPort.openPort();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        serialPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
            }

            @Override
            public void serialEvent(SerialPortEvent serialPortEvent) {
                if(serialPortEvent.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED)
                {
                    String data = new String(serialPortEvent.getReceivedData());
                    System.out.println(data);

                }
            }
        });

    }
}

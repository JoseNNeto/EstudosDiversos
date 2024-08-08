package com.example.study.serial.studyserial.ListarPortas;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortIOException;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;

public class SerialReader {
    private String portName;

    public SerialReader(String portName) {
        this.portName = portName;
    }

    public void readData() {
        try {
            SerialPort serialPort = SerialPort.getCommPort(portName);
            serialPort.openPort(0);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
            serialPort.setComPortParameters(0, 0, 0, 0)
            serialPort.setComPortParameters(0, 0, 0, 0, false)

            InputStream inputStream = serialPort.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            while (true) {
                if (scanner.hasNextLine()) {
                    String weightData = scanner.nextLine();
                    System.out.println(portName +": " + weightData);
                } else{
                    scanner.close();
                    break;
                }
            }

        } catch (SerialPortInvalidPortException e) {
            System.err.println("Error opening serial port: " + e.getMessage());
        } 
    }
}

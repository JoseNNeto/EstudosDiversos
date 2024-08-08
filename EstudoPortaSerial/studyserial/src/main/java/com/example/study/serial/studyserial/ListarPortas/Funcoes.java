package com.example.study.serial.studyserial.ListarPortas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fazecast.jSerialComm.SerialPort;

public class Funcoes {
    private List<String> portNames;
    private List<String> availablePorts; // Added to store detected ports

    public Funcoes(List<String> portNames) {
        this.portNames = portNames;
        this.availablePorts = new ArrayList<>(); // Initialize availablePorts list
    }

    public void ListarPortas(){

        SerialPort[] portas = SerialPort.getCommPorts();

        // Verifica se há portas disponíveis

        if (portas.length == 0) {

            System.out.println("Nenhuma porta serial encontrada.");

        } else {

            System.out.println("Portas seriais disponíveis:");

            // Lista as portas disponíveis e as adiciona à lista availablePorts

            for (SerialPort porta : portas) {
                System.out.println(porta.getSystemPortName());
                availablePorts.add(porta.getSystemPortName()); // Add port name to list
            }

        }

    }

    public void readData() {
        ExecutorService executor = Executors.newFixedThreadPool(availablePorts.size()); // Use availablePorts size

        for (String portName : availablePorts) { // Read from detected ports
            SerialReader reader = new SerialReader(portName);
            executor.submit(reader::readData);
        }

        executor.shutdown(); // Aguarda a finalização das threads
    }
}

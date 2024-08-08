package com.example.study.serial.studyserial.ListarPortas;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiLeitor {
    private List<String> portNames;

    public MultiLeitor(List<String> portNames) {
        this.portNames = portNames;
    }

    public void readData() {
        ExecutorService executor = Executors.newFixedThreadPool(portNames.size());

        for (String portName : portNames) {
            SerialReader reader = new SerialReader(portName);
            executor.submit(reader::readData);
        }

        executor.shutdown(); // Aguarda a finalização das threads
    }
}

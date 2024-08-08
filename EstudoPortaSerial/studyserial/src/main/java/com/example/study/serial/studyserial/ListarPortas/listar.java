package com.example.study.serial.studyserial.ListarPortas;

import com.fazecast.jSerialComm.SerialPort;

public class listar {
    public void ListarPortas(){
        SerialPort[] portas = SerialPort.getCommPorts();

        // Verifica se há portas disponíveis
        if (portas.length == 0) {
            System.out.println("Nenhuma porta serial encontrada.");
        } else {
            System.out.println("Portas seriais disponíveis:");
            // Lista as portas disponíveis
            for (SerialPort porta : portas) {
                System.out.println(porta.getSystemPortName());
            }
        }
    }
}

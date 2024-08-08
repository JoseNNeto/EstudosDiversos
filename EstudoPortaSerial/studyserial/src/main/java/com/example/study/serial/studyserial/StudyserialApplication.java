package com.example.study.serial.studyserial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.study.serial.studyserial.ListarPortas.Funcoes;

@SpringBootApplication
public class StudyserialApplication {
	public static void main(String[] args) {
        List<String> portNames = new ArrayList<>();

        Funcoes reader = new Funcoes(portNames);

        reader.ListarPortas();

        reader.readData();
	}
}

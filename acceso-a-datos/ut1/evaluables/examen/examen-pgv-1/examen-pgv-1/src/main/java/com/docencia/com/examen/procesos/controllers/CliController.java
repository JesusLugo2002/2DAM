package com.docencia.com.examen.procesos.controllers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.com.examen.procesos.services.impl.DfServiceImpl;

@Service
public class CliController {

    @Autowired
    public DfServiceImpl dfService;

    public void consoleMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\n" +
                "Comandos:\n" +
                "  df -h\n" +
                "  df -H\n" +
                "  Df -H | head\n");
        String commandStr = scanner.nextLine();

        if (commandStr.toUpperCase().startsWith("DF")) dfService.processLine(commandStr, true);

        scanner.close();
    }
}

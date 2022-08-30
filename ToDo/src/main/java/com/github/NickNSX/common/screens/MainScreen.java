package com.github.NickNSX.common.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.github.NickNSX.common.util.AppContext;

public class MainScreen extends AbstractScreen {

    private static final String greenText = "\u001B[32m";
    private static final String redText = "\u001B[31m";
    private static final String defaultText = "\u001B[0m";

    public MainScreen(BufferedReader consoleReader) {
        super("MainScreen", consoleReader);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void render() throws IOException {

        System.out.println(greenText + "+----------------------------------------------------+\n" + defaultText);
        // TODO Auto-generated method stub
        String mainMenu = "Welcome to To Do List!\n" +
                        "Select from the options:\n" +
                        "1) Add new task\n" +
                        "2) See tasks\n" +
                        "3) Delete Entry\n" +
                        "4) Exit\n" +
                        "> ";

        System.out.print(mainMenu);

        String userSelection = consoleReader.readLine();

        switch(userSelection) {
            case "1":
                new AddTask(consoleReader).render();
                break;
            case "2":
                new SeeTask(consoleReader).render();
                break;
            case "3":
                new DeleteEntry(consoleReader).render();
                break;
            case "4":
                System.out.println("Shutting Down");
                AppContext.shutdown();
                break;
            default:
                System.out.println(redText + "Selection does not match options." + defaultText);
        }
    }
}

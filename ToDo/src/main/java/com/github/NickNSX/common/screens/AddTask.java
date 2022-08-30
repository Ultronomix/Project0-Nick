package com.github.NickNSX.common.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.github.NickNSX.users.User;
import com.github.NickNSX.users.UserDAO;

public class AddTask extends AbstractScreen {

    private static final String redText = "\u001B[31m";
    private static final String defaultText = "\u001B[0m";

    public AddTask(BufferedReader consoleReader) {
        super("AddTaskScreen", consoleReader);
    }

    @Override
    public void render() throws IOException {
        // TODO Auto-generated method stub
        // System.out.println("Add Task Screen works");

        User newUser = new User();
        UserDAO userDAO = new UserDAO();

        System.out.println("Enter Info");

        boolean formCompleted = false;

        while (!(formCompleted)) {

            System.out.print("Enter Name > ");
            String name = consoleReader.readLine();

            if (name == null || name.trim().equals("")) {
                System.out.println(redText + "Invalid name. Restarting" + defaultText);
                continue;
            }

            newUser.setName(name);

            System.out.print("Enter task > ");
            String task = consoleReader.readLine();

            if (task == null || task.trim().equals("")) {
                System.out.println(redText + "Invalid task. Restarting" + defaultText);
                continue;
            }

            newUser.setTask(task);

            formCompleted = true;
        }

        //UserDAO userDAO = new UserDAO();
        String entered = userDAO.save(newUser);

        System.out.println("Entered: " + entered);

        // TODO checks
    }

}

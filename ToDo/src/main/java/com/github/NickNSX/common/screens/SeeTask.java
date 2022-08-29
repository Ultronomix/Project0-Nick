package com.github.NickNSX.common.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.github.NickNSX.users.User;
import com.github.NickNSX.users.UserDAO;

public class SeeTask extends AbstractScreen {

    UserDAO userDAO = new UserDAO();

    public SeeTask(BufferedReader consoleReader) {

        super("SeeTaskScreen", consoleReader);
    }

    @Override
    public void render() throws IOException {
        // TODO Auto-generated method stub
        System.out.println("Displaying all Entry.\nWorking...");
       List<User> users = userDAO.getAllUsers();
        for (User user: users) {
            System.out.println(user);
        }
    }

}

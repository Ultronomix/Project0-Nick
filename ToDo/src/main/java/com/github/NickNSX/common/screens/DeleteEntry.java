package com.github.NickNSX.common.screens;

import java.io.BufferedReader;
import java.io.IOException;

import com.github.NickNSX.users.User;
import com.github.NickNSX.users.UserDAO;

public class DeleteEntry extends AbstractScreen{

    private final String redText = "\u001B[31m";
    private final String defaultText = "\u001B[0m";

    public DeleteEntry(BufferedReader consolReader) {
        super("DeleteEntry", consolReader);
    }

    @Override
    public void render() throws IOException {
        
        User delUser = new User();
        UserDAO userDAO = new UserDAO();
        String del = "";

        new SeeTask(consoleReader).render();

        System.out.print("Enter name to delete > ");
        String name = consoleReader.readLine();

        delUser.setName(name);

        System.out.print("Confirm Delete (y/n): " + redText + delUser.getName().toUpperCase() + defaultText + " > ");
        String confirm = consoleReader.readLine();

        switch(confirm) {
            case "y":
                del = userDAO.deleteEntry(delUser);
                break;
            default:
                System.out.println("Nothing deleted");
        }
        System.out.println(del);
    }
}

/*  Ask the user which entry to delete and confirm if they
 * want to delete that entry. It takes a name and delete the
 * entry with the matching name.
 */
package com.github.NickNSX.users;

import java.util.Objects;

//POJO = Plain Ol' Java Object
public class User {

    private final String yellowText = "\u001B[33m";
    private final String defaultText = "\u001B[0m";

    private int num_row;
    private String name;
    private String task;

    public int getNum_row() {
        return num_row;
    }

    public void setRow_num(int num_row) {
        this.num_row = num_row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(task, user.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, task);
    }

    @Override
    public String toString() {
        return yellowText + "User " + defaultText + "{" +
                yellowText + "num_row " + defaultText + "= '" + defaultText + num_row +  "' " +
                yellowText + "name " + defaultText + "= '" + defaultText + name + "' " +
                yellowText + "task "+ defaultText + "= '" + defaultText + task +
                "'}";
    }
}

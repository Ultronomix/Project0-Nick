package com.github.NickNSX.common.screens;

import java.io.BufferedReader;

public abstract class AbstractScreen implements Screen {
    
    protected String name;
    protected BufferedReader consoleReader;

    public AbstractScreen(String name, BufferedReader consolReader) {
        this.name = name;
        this.consoleReader = consolReader;
    }

    public String getName() {
        return name;
    }
}

package com.github.NickNSX.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.github.NickNSX.common.screens.MainScreen;
import com.github.NickNSX.common.screens.Screen;

public class AppContext {
    private static boolean appRunning;
    private BufferedReader consolReader;

    public AppContext() {
        appRunning = true;
        consolReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startApp() {
        while (appRunning) {
            try {
                Screen currentScreen = new MainScreen(consolReader);
                currentScreen.render();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        appRunning = false;
    }

}

package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    static public void writeMessage(String message) {
        System.out.println(message);
    }

    static public String readString() throws IOException {
        return consoleReader.readLine();
    }

    static public int readInt() throws IOException, NumberFormatException {
        return Integer.parseInt(readString());
    }
}

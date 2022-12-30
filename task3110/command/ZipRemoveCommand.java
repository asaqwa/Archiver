package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {

        ConsoleHelper.writeMessage("Removing file.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Enter file name:");
        Path destinationPath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(destinationPath);

        ConsoleHelper.writeMessage("Operation completed.");
    }
}
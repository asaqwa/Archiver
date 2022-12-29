package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter an archive path:");
            String archivePath = consoleReader.readLine();
//            archivePath = "C:\\!!! Arbeitsordner\\test.zip";
            ZipFileManager zipManager = new ZipFileManager(Paths.get(archivePath));

            System.out.println("Enter the path to the file to archive:");
            String fileToArchPath = consoleReader.readLine();
//            fileToArchPath = "C:\\!!! Arbeitsordner\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task31\\tasks_order.txt";
            zipManager.createZip(Paths.get(fileToArchPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

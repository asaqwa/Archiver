package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        if (!Files.exists(zipFile.getParent())) Files.createDirectories(zipFile.getParent());

        try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOut, source.getParent(), source.getFileName());

            } else if (Files.isDirectory(source)) {
                List<Path> fileNames = new FileManager(source).getFileList();
                for (Path path : fileNames) {
                    addNewZipEntry(zipOut, source, path);
                }

            } else throw new PathIsNotFoundException();
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            zipOutputStream.putNextEntry(new ZipEntry(fileName.toString()));
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[Math.min(1_048_576, in.available())];
        int i;
        while ((i=in.read(buffer)) > 0) {
            out.write(buffer, 0, i);
        }
    }
}

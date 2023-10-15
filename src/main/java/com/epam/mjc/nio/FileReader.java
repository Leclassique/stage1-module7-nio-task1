package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] params = currentLine.split(": ");
                stringBuilder.append(params[1]).append(",");
            }
            String[] params = stringBuilder.toString().split(",");
            return new Profile(params[0], params[1], params[2], params[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> map) {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, false);
            StringBuilder builder = new StringBuilder();

            map.forEach((symptom, amount) -> builder.append(symptom).append(":").append(amount.toString()).append("\n"));
            fileWriter.write(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.hemebiotech.analytics;

import com.hemebiotech.analytics.exception.WriteException;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> map) {
        try (FileWriter fileWriter = new FileWriter(this.filePath, false)) {

            StringBuilder builder = new StringBuilder();

            map.forEach((symptom, amount) -> builder.append(symptom).append(":").append(amount.toString()).append("\n"));
            fileWriter.write(builder.toString());

        } catch (Exception e) {
            throw new WriteException(e.getMessage(), e.getCause());
        }
    }
}
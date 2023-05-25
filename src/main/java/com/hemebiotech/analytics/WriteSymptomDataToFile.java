package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> map) {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, false);

            Map<String, Integer> sortedMap = sortAlphabetically(map);

            sortedMap.forEach((symptom, amount) -> {
                try {
                    fileWriter.write(symptom+":"+amount.toString()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> sortAlphabetically(Map<String, Integer> unsortedMap) {
        return new TreeMap<>(unsortedMap);
    }
}
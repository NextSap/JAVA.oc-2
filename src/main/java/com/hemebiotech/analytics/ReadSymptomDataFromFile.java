package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filePath;

    /**
     * @param filePath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e.getCause());
            }
        }

        return result;
    }
}

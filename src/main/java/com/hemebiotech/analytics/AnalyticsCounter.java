package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private final ISymptomReader iSymptomReader;
    private final ISymptomWriter iSymptomWriter;


    public AnalyticsCounter(ISymptomReader iSymptomReader, ISymptomWriter iSymptomWriter) {
        this.iSymptomReader = iSymptomReader;
        this.iSymptomWriter = iSymptomWriter;
    }

    public List<String> getSymptoms() {
        return this.iSymptomReader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> finalSymptoms = new HashMap<>();

        for(String symptom : symptoms) {
            if(finalSymptoms.containsKey(symptom)) {
                finalSymptoms.put(symptom, finalSymptoms.get(symptom) + 1);
            } else {
                finalSymptoms.put(symptom, 1);
            }
        }

        return finalSymptoms;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.iSymptomWriter.writeSymptoms(symptoms);
    }
}

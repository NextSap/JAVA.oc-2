package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomDataToFile write = new WriteSymptomDataToFile("result.out");

        List<String> symptoms = read.getSymptoms();

        Map<String, Integer> finalSymptoms = new HashMap<>();

        for(String symptom : symptoms) {
            if(finalSymptoms.containsKey(symptom)) {
                finalSymptoms.put(symptom, finalSymptoms.get(symptom) + 1);
            } else {
                finalSymptoms.put(symptom, 1);
            }
        }

        write.writeSymptoms(finalSymptoms);
    }
}

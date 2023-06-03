package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("src/main/resources/symptoms.txt");
        WriteSymptomDataToFile write = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(read, write);

        List<String> symptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);

        analyticsCounter.writeSymptoms(analyticsCounter.sortSymptoms(countSymptoms));
    }
}

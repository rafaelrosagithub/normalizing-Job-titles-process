package com.rafael.api.normalize.service;

import com.rafael.api.normalize.dto.Normalize;
import com.rafael.api.normalize.exception.NormalizeException;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NormalizeService {

    private final Normalize normalize;
    private final LevenshteinDistance levenshteinDistance;

    public NormalizeService() {
        List<String> titles = Arrays.asList("Architect", "Software Engineer", "Quantity Surveyor", "Accountant");
        this.normalize = new Normalize(titles);
        this.levenshteinDistance = new LevenshteinDistance();
    }

    // Method to normalize the input job title to the closest predefined job title
    public String normalizeJobTitle(String jobTitle) {
        String closestMatch = null;
        int minDistance = Integer.MAX_VALUE;

        // Iterate through all normalized job titles to find the closest match using Levenshtein distance
        for (String normalizedTitle : normalize.normalizedJobTitles()) {
            int distance = levenshteinDistance.apply(jobTitle.toLowerCase(), normalizedTitle.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = normalizedTitle;
            }
        }

        // Throw exception if no match found
        if (closestMatch == null) {
            throw new NormalizeException("No normalized job title found for input: " + jobTitle);
        }

        return closestMatch;
    }

    // Method to retrieve the list of predefined normalized job titles
    public List<String> getNormalizedJobTitles() {
        return normalize.normalizedJobTitles();
    }
}

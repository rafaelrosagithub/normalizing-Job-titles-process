package com.rafael.api.normalize.service;

import com.rafael.api.normalize.dto.Normalize;
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

    public String normalizeJobTitle(String jobTitle) {
        String closestMatch = null;
        int minDistance = Integer.MAX_VALUE;

        for (String normalizedTitle : normalize.normalizedJobTitles()) {
            int distance = levenshteinDistance.apply(jobTitle.toLowerCase(), normalizedTitle.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = normalizedTitle;
            }
        }

        return closestMatch;
    }

    public List<String> getNormalizedJobTitles() {
        return normalize.normalizedJobTitles();
    }
}

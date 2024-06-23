package com.rafael.api.normalizer.service;

import com.rafael.api.normalizer.dto.Normalizer;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NormalizerService {

    private final Normalizer normalizer;
    private final LevenshteinDistance levenshteinDistance;

    public NormalizerService() {
        List<String> titles = Arrays.asList("Architect", "Software Engineer", "Quantity Surveyor", "Accountant");
        this.normalizer = new Normalizer(titles);
        this.levenshteinDistance = new LevenshteinDistance();
    }

    public String normalizeJobTitle(String jobTitle) {
        String closestMatch = null;
        int minDistance = Integer.MAX_VALUE;

        for (String normalizedTitle : normalizer.normalizedJobTitles()) {
            int distance = levenshteinDistance.apply(jobTitle.toLowerCase(), normalizedTitle.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = normalizedTitle;
            }
        }

        return closestMatch;
    }

    public List<String> getNormalizedJobTitles() {
        return normalizer.normalizedJobTitles();
    }
}

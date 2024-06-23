package com.rafael.api.normalizer.controllers;

import com.rafael.api.normalizer.service.NormalizerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/normalizer")
public class NormalizerController {

    private final NormalizerService normalizerService;

    public NormalizerController(NormalizerService normalizerService) {
        this.normalizerService = normalizerService;
    }

    @GetMapping("/{jobTitle}")
    public String normalizeJobTitle(@PathVariable String jobTitle) {
        return normalizerService.normalizeJobTitle(jobTitle);
    }

    @GetMapping("/titles")
    public List<String> getNormalizedJobTitles() {
        return normalizerService.getNormalizedJobTitles();
    }
}

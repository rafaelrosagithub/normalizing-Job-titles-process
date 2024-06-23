package com.rafael.api.normalize.controller;

import com.rafael.api.normalize.service.NormalizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/normalizer")
public class NormalizeController {

    private final NormalizeService normalizerService;

    public NormalizeController(NormalizeService normalizerService) {
        this.normalizerService = normalizerService;
    }

    @GetMapping("/{jobTitle}")
    public String normalizeJobTitleController(@PathVariable String jobTitle) {
        return normalizerService.normalizeJobTitle(jobTitle);
    }

    @GetMapping("/titles")
    public List<String> getNormalizedJobTitles() {
        return normalizerService.getNormalizedJobTitles();
    }
}

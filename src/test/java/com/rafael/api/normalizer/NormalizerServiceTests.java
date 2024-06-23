package com.rafael.api.normalizer;

import com.rafael.api.normalizer.service.NormalizerService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalizerServiceTests {

    @Test
    public void testNormalizeJobTitle() {
        // Create an instance of NormalizerService
        NormalizerService service = new NormalizerService();

        // Test cases for normalizeJobTitle method
        assertEquals("Software Engineer", service.normalizeJobTitle("Java Engineer"));
        assertEquals("Software Engineer", service.normalizeJobTitle("C# Engineer"));
        assertEquals("Accountant", service.normalizeJobTitle("Accountant"));
        assertEquals("Accountant", service.normalizeJobTitle("Chief Accountant"));
    }

    @Test
    public void testGetNormalizedJobTitles() {
        // Create an instance of the service
        NormalizerService service = new NormalizerService();

        // Call the method under test
        List<String> actualTitles = service.getNormalizedJobTitles();

        // Define the expected list of normalized titles
        List<String> expectedTitles = Arrays.asList("Architect", "Software Engineer", "Quantity Surveyor", "Accountant");

        // Verify if the returned list is equal to the expected list
        assertEquals(expectedTitles, actualTitles);
    }

}
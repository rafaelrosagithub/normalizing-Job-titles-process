package com.rafael.api.normalize.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalizeServiceTest {

    @Test
    public void testNormalizeJobTitle() {
        // Create an instance of NormalizeService
        NormalizeService service = new NormalizeService();

        // Test cases for normalizeJobTitle method
        assertEquals("Software Engineer", service.normalizeJobTitle("Java Engineer"));
        assertEquals("Software Engineer", service.normalizeJobTitle("C# Engineer"));
        assertEquals("Accountant", service.normalizeJobTitle("Accountant"));
        assertEquals("Accountant", service.normalizeJobTitle("Chief Accountant"));
    }

    @Test
    public void testGetNormalizedJobTitles() {
        // Create an instance of the service
        NormalizeService service = new NormalizeService();

        // Call the method under test
        List<String> actualTitles = service.getNormalizedJobTitles();

        // Define the expected list of normalized titles
        List<String> expectedTitles = Arrays.asList("Architect", "Software Engineer", "Quantity Surveyor", "Accountant");

        // Verify if the returned list is equal to the expected list
        assertEquals(expectedTitles, actualTitles);
    }

}
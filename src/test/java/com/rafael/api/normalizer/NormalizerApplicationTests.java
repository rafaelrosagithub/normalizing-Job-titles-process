package com.rafael.api.normalizer;

import com.rafael.api.normalizer.service.NormalizerService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalizerApplicationTests {

    @Test
    public void testNormalizeJobTitle() {
        NormalizerService service = new NormalizerService();

        assertEquals("Software Engineer", service.normalizeJobTitle("Java Engineer"));
        assertEquals("Software Engineer", service.normalizeJobTitle("C# Engineer"));
        assertEquals("Accountant", service.normalizeJobTitle("Accountant"));
        assertEquals("Accountant", service.normalizeJobTitle("Chief Accountant"));
    }

}

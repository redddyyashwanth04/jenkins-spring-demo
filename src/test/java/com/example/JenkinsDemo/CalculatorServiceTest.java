package com.example.JenkinsDemo;

import com.example.JenkinsDemo.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    public void testAdd() {
        // Intentional failure to trigger the Jenkins CI/CD quality gate
        assertEquals(50, service.add(2, 3));
    }
}
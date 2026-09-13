package com.example.JenkinsDemo.controller;


import com.example.JenkinsDemo.service.CalculatorService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {
    private final CalculatorService calculatorService;
    public DemoController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "service", "jenkins-spring-demo",
                "version", System.getenv().getOrDefault("APP_VERSION", "dev")
        );
    }

    @GetMapping("/add")
    public Map<String, Integer> add(@RequestParam int a, @RequestParam int b) {
        return Map.of("result", calculatorService.add(a, b));
    }
}

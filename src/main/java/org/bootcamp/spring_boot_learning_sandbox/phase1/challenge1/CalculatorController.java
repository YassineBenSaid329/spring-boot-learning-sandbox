package org.bootcamp.spring_boot_learning_sandbox.phase1.challenge1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public String add(
            @RequestParam int a,
            @RequestParam int b
    ) {
        return "The result is: " + (a+b);
    }
}

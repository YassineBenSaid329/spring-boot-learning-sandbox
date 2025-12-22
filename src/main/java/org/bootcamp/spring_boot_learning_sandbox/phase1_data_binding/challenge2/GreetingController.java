package org.bootcamp.spring_boot_learning_sandbox.phase1_data_binding.challenge2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge2/greet")
public class GreetingController {

    @GetMapping("/{username}/{age}")
    public String greet(
            @PathVariable String username,
            @PathVariable int age
    ) {
        return (age < 18) ? "Hello " + username + ", you are too young!" : "Welcom " + username + ", come on in!";
    }
}

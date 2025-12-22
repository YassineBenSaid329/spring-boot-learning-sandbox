package org.bootcamp.spring_boot_learning_sandbox.phase1_data_binding.challenge3;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge3/products")
public class ProductController {
    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return (product.getPrice() < 0) ? "Error: Price cannot be negative" : "Product " + product.getName() + " created successfully with price " + product.getPrice() ;
    }
}

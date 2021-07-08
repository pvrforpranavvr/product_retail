package com.product.productretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.product.productretail.repository")
@SpringBootApplication
public class ProductRetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductRetailApplication.class, args);
    }

}

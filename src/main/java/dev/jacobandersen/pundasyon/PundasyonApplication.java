package dev.jacobandersen.pundasyon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PundasyonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PundasyonApplication.class, args);
    }
}

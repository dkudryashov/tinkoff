package ru.dkudryashov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Dmitry on 04.04.17.
 */
@EnableCaching
@SpringBootApplication
@ComponentScan("ru.dkudryashov")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

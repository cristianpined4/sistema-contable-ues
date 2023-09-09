package fmoues.edu.sv.sistemascontable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class SistemasContableApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemasContableApplication.class, args);
    }
}


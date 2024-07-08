package br.com.ekan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.ekan.*")
@EnableJpaRepositories(basePackages = "br.com.ekan.repository")
@PropertySource("classpath:application.properties")
public class RegistroApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistroApplication.class, args);
    }
}

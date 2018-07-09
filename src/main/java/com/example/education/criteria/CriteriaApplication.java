package com.example.education.criteria;

import com.example.education.criteria.services.StaffService;
import com.example.education.criteria.services.servicesImpl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.education.criteria.repositories")
@ComponentScan(basePackages = "com.example.education.criteria")
@EntityScan(basePackages = "com.example.education.criteria.domain")
public class CriteriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CriteriaApplication.class, args);
    }
}


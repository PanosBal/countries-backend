package com.qualco.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.qualco.countries.mapper")
public class CountriesBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountriesBackendApplication.class, args);
    }

}

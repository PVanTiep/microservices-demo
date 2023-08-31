package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.WikipediaToKafkaServiceConfigData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;


@SpringBootApplication
@Slf4j
@ComponentScan("com.microservices.demo")
@RequiredArgsConstructor
public class DataToKafkaServiceApplication implements CommandLineRunner {

    private final WikipediaToKafkaServiceConfigData wikipediaToKafkaServiceConfigData;
    public static void main(String[] args) {
        SpringApplication.run(DataToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        log.info("Twitter keywords: {}", Arrays.toString(wikipediaToKafkaServiceConfigData.getTwitterKeywords().toArray()));
        log.info("Welcome message: {}", wikipediaToKafkaServiceConfigData.getWelcomeMessage());
    }
}

package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.TwitterToKafkaServiceConfigData;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;
    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        log.info("Twitter keywords: {}", Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray()));
        log.info("Welcome message: {}", twitterToKafkaServiceConfigData.getWelcomeMessage());
    }
}

package com.microservices.demo.twitter.to.kafka.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.demo.twitter.to.kafka.service.dto.WikimediaRecentChangeDto;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.io.IOException;
import java.util.Objects;


@RestController
public class StreamApiController {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public StreamApiController(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org")
                .build();
        this.objectMapper = objectMapper;
    }

    @GetMapping("/stream-wikipedia")
    public Flux<ServerSentEvent<WikimediaRecentChangeDto>> streamWikipediaChanges() {
        return webClient.get().uri("/v2/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .map(message -> ServerSentEvent.builder(Objects.requireNonNull(toDto(message))).build());
    }
    private Long extractIdFromJson(String jsonData) {
        try {
            WikimediaRecentChangeDto changeDto = objectMapper.readValue(jsonData, WikimediaRecentChangeDto.class);
            return changeDto.getId();
        } catch (IOException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
            return null;
        }
    }
    private WikimediaRecentChangeDto toDto(String message){
        try {
            WikimediaRecentChangeDto changeDto = objectMapper.readValue(message, WikimediaRecentChangeDto.class);
            return changeDto;
        } catch (IOException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
            return null;
        }
    }
}

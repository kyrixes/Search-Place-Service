package com.example.placesearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class EmbeddedRedisConfig {

    private RedisServer redisServer;

    @Value("${redis.port}")
    private int redisPort;

    @PostConstruct
    public void redisServer() throws IOException {
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stop() {
        if (redisServer != null)
            redisServer.stop();
    }
}

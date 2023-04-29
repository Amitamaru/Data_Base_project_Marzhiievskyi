package com.javarush.marzhiievskyi;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;

import static java.util.Objects.isNull;

public class RedisConnection {
    private static RedisConnection instance;
    private final RedisClient redisClient;

    public RedisConnection() {
        redisClient = RedisClient.create(RedisURI.create("localhost", 6379));
        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            System.out.println("\n==Connected to Redis==\n");
        }
    }

    public static RedisClient getRedisClient() {
        if (isNull(instance)) {
            instance = new RedisConnection();
        }

        return instance.redisClient;
    }
}

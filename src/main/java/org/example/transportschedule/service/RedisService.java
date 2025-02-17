package org.example.transportschedule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String,Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public void saveData(String key, Object value, Long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
    }

    public <T> T getData(String key, Class<T> clazz) {
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj == null) {
            return null;
        }
        return objectMapper.convertValue(obj, clazz);
    }

    public <T> List<T> getAllData(String key, Class<T> clazz) {
        Set<String> keys = redisTemplate.keys(key + "*");
        List<T> result = Collections.emptyList();
        if (!keys.isEmpty()) {
            result = (List<T>) redisTemplate.opsForValue().multiGet(keys);
        }
        return result.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }

    public void deleteData(String key) {
        redisTemplate.delete(key);
    }


}

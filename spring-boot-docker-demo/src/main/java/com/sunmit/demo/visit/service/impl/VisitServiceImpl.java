package com.sunmit.demo.visit.service.impl;

import com.sunmit.demo.visit.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Long visitAdd() {
        String visit_number_key = "visit_number";
        Long num = redisTemplate.opsForValue().increment(visit_number_key);
        return num;
    }
}

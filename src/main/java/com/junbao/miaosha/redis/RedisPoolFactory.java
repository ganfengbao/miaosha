package com.junbao.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

	@Autowired
	RedisConfig redisConfig;
	
	@Bean
	public JedisPool JedisPoolFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxTotal(10);
		poolConfig.setMaxWaitMillis(3 * 1000);
		JedisPool jp = new JedisPool(poolConfig, "192.168.136.128", 6379,
				3*1000, null, 0);
		return jp;
	}
	
}

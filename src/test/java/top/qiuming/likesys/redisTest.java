package top.qiuming.likesys;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Slf4j
class redisTest{
	@Autowired
	StringRedisTemplate redisTemplate;
	@Test
	public void testStrings(){
		 String redisKey = "hello";
		redisTemplate.opsForValue().set(redisKey,"1");
		log.info("返回结果："+redisTemplate.opsForValue().get(redisKey));
		redisTemplate.opsForValue().increment("hello");
		log.info("返回结果："+redisTemplate.opsForValue().get(redisKey));
	}

}

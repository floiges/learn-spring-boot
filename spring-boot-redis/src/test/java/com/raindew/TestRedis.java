package com.raindew;

import com.raindew.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author raindew
 * @Date 2019-08-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testObj() throws Exception {
		User user = new User("aa", "123456", "aa@126.com", "aa", "123");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("com.raindew", user);
		operations.set("com.randew.f", user, 1, TimeUnit.SECONDS);
		Thread.sleep(1000);

		boolean exists = redisTemplate.hasKey("com.raindew.f");
		if (exists) {
			System.out.println("com.raindew.f exist");
		} else {
			System.out.println("ecom.raindew.f not exist");
		}
	}
}

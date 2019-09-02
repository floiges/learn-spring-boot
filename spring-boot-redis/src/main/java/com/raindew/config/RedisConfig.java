package com.raindew.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author yadong
 * @Date 2019-08-20
 * cache 配置类
 */
@Configuration
@EnableCaching // 开启缓存
public class RedisConfig extends CachingConfigurerSupport {
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj: params) {
					sb.append(obj.toString());
				}
				return sb.toString(); // 缓存的key是类名+方法名+方法参数
			}
		};
	}
}

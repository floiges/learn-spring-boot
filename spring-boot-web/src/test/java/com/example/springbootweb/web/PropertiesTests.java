package com.example.springbootweb.web;

import com.example.springbootweb.util.CustomProperties;
import org.hibernate.boot.model.source.spi.Orderable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTests {
	@Autowired
	private CustomProperties properties;

	@Test
	public void getHello() throws Exception {
		System.out.println(properties.getTitle());
		Assert.assertEquals(properties.getTitle(), "纯洁的微笑");
		Assert.assertEquals(properties.getDescription(), "分享生活和技术");
	}
}

package com.raindew.web;

import com.raindew.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author raindew
 * @Date 2019/9/2
 */
@RestController
public class UserController {
	@RequestMapping("/getUser")
	@Cacheable(value = "user-key") // 自动根据方法生成缓存
	public User getUser() {
		User user = new User("aa", "aa123456", "aaa@126.com", "aa", "123");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}

	@RequestMapping("/uid") // 获取 sessionid
	String uid(HttpSession session) {
		UUID uid = (UUID)session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}
}

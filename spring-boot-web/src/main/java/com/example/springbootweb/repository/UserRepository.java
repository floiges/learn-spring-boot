package com.example.springbootweb.repository;

import com.example.springbootweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO 继承 JpaRepository，可以根据方法名自动生成 SQL
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	User findByUserNameOrEmail(String userName, String email);
}

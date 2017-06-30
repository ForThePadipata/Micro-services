package com.github.origin.dao;

import com.github.origin.entity.User;
import com.github.origin.server.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * Created by Zhu on 2017/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception{
		User u = userMapper.findByName("test");
		System.out.println(u.toString());
	}

	@Test
	@Rollback
	public void addUser() throws Exception{
		User u = new User();
		u.setUserNo("123321");
		u.setUsername("test" + new Random().nextInt(299));
		u.setPassword("123");
		u.setMobile("13627891234");
		u.setEmail(u.getUsername() + "@live.com");
		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		u.setLastPasswordResetDate(Date.from(instant));
		int i = userMapper.insert(u);
		System.out.println(i);
	}

}

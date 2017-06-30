package com.github.origin.server.dao;

import com.github.origin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Zhu on 2017/6/28.
 */
@Mapper
public interface UserMapper {

	//@Select("SELECT * FROM T_USER WHERE USERNAME = #{username}")
	User findByName(@Param("username") String username);

	//@Insert("INSERT INTO T_USER(USER_NO, USERNAME, PASSWORD, MOBILE, EMAIL, LAST_PASSWORD_RESET_DATE, ROLES) VALUES(#{userNo}, #{username}, #{password}, #{mobile}, #{email}, #{lastPasswordResetDate}, #{roles})")
	int insert(User user);

}

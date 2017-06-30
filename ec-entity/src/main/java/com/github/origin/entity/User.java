package com.github.origin.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by Zhu on 2017/6/5.
 */
@Data
public class User {

	private int id;

	private String userNo;

	private String username;

	private String password;

	private String mobile;

	private String email;

	private Date lastPasswordResetDate;

	private String roles;

}

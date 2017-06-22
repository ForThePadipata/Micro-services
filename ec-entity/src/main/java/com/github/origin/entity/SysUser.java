package com.github.origin.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Zhu on 2017/5/3.
 */
@Data
public class SysUser {

	private int id;

	private String sysUserNo;

	private String sysUserName;

	private String sysPassword;

	private String salt;

	private String mobile;

	private String email;

	private String registerTime;

	private String loginIp;

	private Date loginSuccessTime;

	private String status;

	private String parentAdmin;

	private String delFlag;
}

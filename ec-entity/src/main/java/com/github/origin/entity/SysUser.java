package com.github.origin.entity;

import java.util.Date;

/**
 * Created by Zhu on 2017/5/3.
 */
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

	public SysUser() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysUserNo() {
		return sysUserNo;
	}

	public void setSysUserNo(String sysUserNo) {
		this.sysUserNo = sysUserNo;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysPassword() {
		return sysPassword;
	}

	public void setSysPassword(String sysPassword) {
		this.sysPassword = sysPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginSuccessTime() {
		return loginSuccessTime;
	}

	public void setLoginSuccessTime(Date loginSuccessTime) {
		this.loginSuccessTime = loginSuccessTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentAdmin() {
		return parentAdmin;
	}

	public void setParentAdmin(String parentAdmin) {
		this.parentAdmin = parentAdmin;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}

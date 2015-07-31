package com.zhen.demo.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.zhen.core.domain.SerializeCloneable;

@Alias("sys_log")
public class Sys_log extends SerializeCloneable{

	private String sl_id;
	private String sl_user_code;
	private String sl_user_name;
	private Date sl_date;
	
	public Date getSl_date() {
		return sl_date;
	}
	public void setSl_date(Date sl_date) {
		this.sl_date = sl_date;
	}
	public String getSl_id() {
		return sl_id;
	}
	public void setSl_id(String sl_id) {
		this.sl_id = sl_id;
	}
	public String getSl_user_code() {
		return sl_user_code;
	}
	public void setSl_user_code(String sl_user_code) {
		this.sl_user_code = sl_user_code;
	}
	public String getSl_user_name() {
		return sl_user_name;
	}
	public void setSl_user_name(String sl_user_name) {
		this.sl_user_name = sl_user_name;
	}
}

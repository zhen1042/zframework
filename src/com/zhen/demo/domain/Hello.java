package com.zhen.demo.domain;

import org.apache.ibatis.type.Alias;

@Alias("hello")
public class Hello {

	private String su_id;
	private String su_code;
	
	public String getSu_id() {
		return su_id;
	}
	public void setSu_id(String su_id) {
		this.su_id = su_id;
	}
	public String getSu_code() {
		return su_code;
	}
	public void setSu_code(String su_code) {
		this.su_code = su_code;
	}
}

/**
 * 
 */
package com.yede.security.browser.validate.code;


import java.util.Date;


/**
 * @author zhailiang
 *
 */
public class ValidateCode {
	
	private String code;
	
	private Date expireTime;
	
	public ValidateCode(String code, int expireIn){
		this.code = code;
		this.expireTime = DateUtils.plusSeconds(new Date(),expireIn);
	}
	
	public ValidateCode(String code, Date expireTime){
		this.code = code;
		this.expireTime = expireTime;
	}
	
	public boolean isExpried() {
		return DateUtils.after(new Date(),expireTime);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
}

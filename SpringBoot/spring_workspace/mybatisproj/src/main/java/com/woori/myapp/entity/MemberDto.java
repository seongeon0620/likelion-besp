package com.woori.myapp.entity;

import com.woori.myapp.common.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto extends BaseDto {
	private Long member_id = 0L;
	private String user_id = "";
	private String password = "";
	private String user_name = "";
	private String email = "";
	private String phone = "";
	private String wdate = "";
	private String zipcode = "";
	private String address1 = "";
	private String address2 = "";
	

	
}

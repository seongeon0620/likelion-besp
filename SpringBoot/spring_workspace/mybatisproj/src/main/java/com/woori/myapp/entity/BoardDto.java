package com.woori.myapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int seq = 0;
	private String title = "";
	private String writer = "";
	private String contents = "";
	private String wdate = "";
	private String hit = "";
}

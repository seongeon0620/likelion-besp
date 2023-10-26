package com.example.hello;

// Dto - Data transfer object
// 테이블에 데이터를 넣거나 가져오거나 한다.
// join의 경우는 join이 되는 항목을 다 가져와야한다. 그래서 여러개의 테이블로부터 Dto가 만들어진다.
// readonly의 경우에는 -VO 접미어를 붙인다.
// 읽고쓰기의 용도로 사용하는 클래스의 경우 -DTO를 붙인다.
// 대부분의 경우 미리 규칙을 정해서 진행한다.
public class PersonDto {
	private int id = 0;
	private String name = "";
	private String phone = "";
	private String email = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// 생성자 만들때 주의사항 - 매개변수가 있는 생성자를 만들면, 시스템이 만들던 기본 생성자를 안 만든다.
	// PersonDto dto = new PersonDto();
		public PersonDto(int id, String name, String phone, String email) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.email = email;
		}
		
	// 부모생성자 호출
	public PersonDto() {
		super();
	}
}

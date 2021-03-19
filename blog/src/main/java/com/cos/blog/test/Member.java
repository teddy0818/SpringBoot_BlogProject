package com.cos.blog.test;

public class Member {
	
	// 변수를 priavate 로 만드는 이유 ? 바로 접근해서 값을 변경한다? 이건 마법이다! 객체지향에 어울리지 않는다! 메소드로 접근하자!
	
	private int id;
	private String username;
	private String password;
	private String email;
	
	//생성자 
	public Member(int id, String username, String password, String email) {
		this.id = id; 
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}

package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
//@RequiredArgsConstructor // final 붙은애들 생성자 만듬 
@Data // getter setter 둘다 만듬 
// @AllArgsConstructor // 생성자 만듬 
@NoArgsConstructor // 파라미터가 없는 생성자 생성 
public class Member {
	
	// 변수를 priavate 로 만드는 이유 ? 바로 접근해서 값을 변경한다? 이건 마법이다! 객체지향에 어울리지 않는다! 메소드로 접근하자!
	// final 은 불변성을 위해 (데이터를 바꿀 생각이 있으면 final 붙이면 안됨)
	
//	private final int id;
//	private final String username;
//	private final String password;
//	private final String email;
	
	private int id;
	private  String username;
	private String password;
	private String email;
	
	// @AllArgsConstructor로 대체 가
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	
	
}

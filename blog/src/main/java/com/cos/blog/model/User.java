package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter 
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체 생성자
@Builder // 빌더 패턴 
//ORM -> Jave(다른언어) Object -> 테이블로 매핑해주는 기술 
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
public class User {
	
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다 -> MySQL의 auto_increment , 오라클의 시퀀스를 따라간다
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 20) // not null, 길이조절 20
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) // 123456 => 해쉬 (비밀번호 암호화) 
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault(" 'user' ") // " 안에 ' 를 붙여줘야함 (문자라는걸 알려줌)
	private String role; // Enum을 쓰는게 좋다. Enum을 쓰면 도메인(범위)을 만들어준다 // String이면 오타를 내서 실수할수있음 //  admin, user, manager 구별
	
	@CreationTimestamp // 시간이 자동입력 
	private Timestamp createDate;
	
}

package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더 패턴
@Data // getter setter 
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체 생성자
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터 
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨 -> 글자의양이 엄청 커짐 
	
	@ColumnDefault("0") // int 형이니까 홑따옴표 (') 필요없음 
	private int count; // 조회수 
	
	@ManyToOne
	// Many = Board, One = User // 한명의 유저가 여러개의 글을 쓸 수 있다 
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할수 없다. 그레서 Foreign key를 쓰는데, 자바는 오브젝트를 저장할 수 있다.
	// User 객체니 User 테이블을 자동으로 참조한다 (Foreign key)
	
	@CreationTimestamp
	private Timestamp createDate;

	

}

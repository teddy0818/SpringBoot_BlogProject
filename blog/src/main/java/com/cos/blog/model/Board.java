package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(fetch = FetchType.EAGER) //  FetchType.EAGER  값을 바로 가져온다 
	// Many = Board, One = User // 한명의 유저가 여러개의 글을 쓸 수 있다 
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할수 없다. 그레서 Foreign key를 쓰는데, 자바는 오브젝트를 저장할 수 있다.
	// User 객체니 User 테이블을 자동으로 참조한다 (Foreign key)
	
	// 하나의 게시물에 여러 댓글을 쓸 수 있다 // 외래키가 필요없다.
	// mappedBy 연관관계의 주인이 아니다. 난 외래키가 아니에요! DB의 칼럼을 만들지 마세요!
	//  FetchType.LAZY : 값을 나중에 들고 올수 있다. ex) 댓글 보기 클릭시 reply객체 들고오기. but 이 프로젝트에선 한번에 다 가져오니까 FetchType.EAGER 쓰자
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;

	

}

package com.cos.blog.model;

import java.sql.Timestamp;

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
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne
	// 여러 개의 댓글은 하나의 게시판에 존재할 수 있다.
	@JoinColumn(name="boardId")
	private Board board; 
	
	@ManyToOne  // 하나의 유저는 여러개의 댓글을 달 수 있다.
	@JoinColumn(name="userId")
	private User user; 
	
	@CreationTimestamp
	private Timestamp createDate;
	

}

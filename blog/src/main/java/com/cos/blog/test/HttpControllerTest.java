package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요창 -> 응답(HTML 파일)
//@Controller

// 사용자가 요청 -> 응답(Data)
// @RestController

@RestController
public class HttpControllerTest {
	
	// 인터넷 브라우저 요청은 무조건 get 방식만 가능함!!
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { // id=1&username=ssar&password=1234&email=ssar@naver.com //  자동으로 spring이 값을 넣어줌 ( MessageConverter (스프링부트))
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail() ;
	}
	
	//http://localhost:8080/http/post (insert)
//	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return  "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail() ;
//	}
	
//	@PostMapping("/http/post") // application/text
//	public String postTest(@RequestBody String text) {
//		return  "post 요청 : " + text;
//	}
	
	@PostMapping("/http/post") // application/json  < - json 방식으로 파싱 
	public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
		return  "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail() ;
	}
	
	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return  "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail() ;
	}
	
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}

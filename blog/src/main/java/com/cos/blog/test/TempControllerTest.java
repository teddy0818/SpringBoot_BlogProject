package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //@Controller 가 붙으면 파일을 리턴한다 
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일 리턴 기본 경로 : src/main/resources/static 
		// static 에선 정적인 파일만 읽을 수 있음  ex) html, img 만 가능 jsp는 불가 -> main에 webapp/WEB-INF/views 폴더 생성 후 jsp 파일 넣
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		System.out.println("tempJsp()");
		
		// prefix : /WEB-INF/views
		// suffix : .jsp
		// 풀네임 :  /WEB-INF/views/test.jsp
		return "test"; // /test를 넣으면   /WEB-INF/views//test.jsp 가 되어버
	}
	
}

package com.example.AjaxEX.service;

import org.springframework.stereotype.Service;

import com.example.AjaxEX.dto.MovieDTO;
import com.example.AjaxEX.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	// MovieService : 보안 , 중복코드 방지, 모듈화 (메소드)  
	//     Controller   ===>   Service ===> Repository 
	// 호출 : Controller 
	// 제어 : Repository 
	
	
	// DI (의존성 주입 : 스프링 프레임 워크에 객체를 주입 ) <== @RequiredArgsConstructor
	private final MovieRepository movieRepository; 
	
	//  DB에 값을 insert 메소드
	public String movieInsert (MovieDTO movieDTO) {
		
		return null ; 
	}
	
	
}

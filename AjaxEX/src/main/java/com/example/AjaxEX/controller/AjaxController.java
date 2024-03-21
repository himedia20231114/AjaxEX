package com.example.AjaxEX.controller;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AjaxEX.dto.AjaxDto;
import com.example.AjaxEX.dto.MovieDTO;
import com.example.AjaxEX.service.MovieService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class AjaxController {
	
	// http://localhost:9696/ex01
	@GetMapping("/ex01")
	public String ex01() {
		System.out.println("ex01 요청 성공 !!!");
		
		// res : index.html 파일의 소스코드가 그대로 전송 
		
		return "index";
	}
	
	//http://localhost:9696/ex02
	// @ResponseBody :  JSON 포멧으로 바꾸어서 전송 
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		System.out.println("ex02 요청 성공 !!!");
		
		return "안녕 하세요" ; 	
	}
	
	// get요청 에서 param으로 넘기는 값을 받기 
		// client 에서 넘기는 data 받기 : param1, param2 
	@GetMapping("/ex03") 
	public @ResponseBody String ex03(
			@RequestParam("param1") String param1 , 
			@RequestParam("param2") String param2
			) {
		System.out.println("ex04 요청 성공 !!! ");
		System.out.println("param1 의 값 : " + param1);
		System.out.println("param2 의 값 : " + param2);
		
		return "03 요청 성공" ; 
	}
	
	// post 요청에서 param으로 값 넘기기 : /ex04?param1=값&param2=값
	@PostMapping("/ex04") 
	public @ResponseBody String ex04(
			@RequestParam("param1") int param1 , 
			@RequestParam("param2") String param2
			) {
		System.out.println("ex04 요청 성공 !!! - post");
		System.out.println("param1 의 값 : " + ( param1  + 10 ));
		System.out.println("param2 의 값 : " + param2);
		
		return "04 요청 성공" ; 
	}
	
	// get 요청에서 param 으로 보내는 변수의 값을 DTO 에 필드에 주입 
	//       -- 주의 : param의 변수명과 DTO 필드 명이 같아야 자동 주입 
	//   @ModelAttribute   <=== param 으로 넘어오는 값을 DTO 에 주입 
	
	@GetMapping("/ex05") 
	public @ResponseBody AjaxDto ex05(
			// 
			@ModelAttribute AjaxDto ajaxDto 
			
			) {
		System.out.println("ex05 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		return ajaxDto ; 
	}
	
	
	
	@PostMapping("/ex06")
	public @ResponseBody AjaxDto ex06(
			@ModelAttribute AjaxDto ajaxDto 
			) {
		System.out.println("ex06 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		return ajaxDto ; 
	}
	
	// client 에서 JSON 으로 서버로 전송 ===> 
	//        @RequestBody(역직열화) JSON ==> DTO 주입 (객체, RAM)   , 
	//        @ResponseBody (직열화) DTO  ==> JSON 
	//    주의 : JSON Data는 get 으로 서버로 전송하면 오류 발생 , POST 로 전송 
	
	@PostMapping("/ex07")
	public @ResponseBody AjaxDto ex07(
			@RequestBody AjaxDto ajaxDto 
			) {
		
		System.out.println("ex07 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		return ajaxDto ; 
	}
	
	// List<AjaxDto> : [{객체}, {객체}, {객체}]   <=== DB 테이블의 각각의 레코드 , select ALL
	@PostMapping("/ex08")
	public @ResponseBody List<AjaxDto> ex08(
			@RequestBody AjaxDto ajaxDto 
			) {
		System.out.println("ex08 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		List<AjaxDto> dtoList = new ArrayList(); 
		
		dtoList.add(ajaxDto);   
		dtoList.add(new AjaxDto("고양이", "호랑이")); 
		dtoList.add(new AjaxDto("사자", "곰"));

		return dtoList; 
	
	}
	
	// REST API 통신 할때 
	//ResponseEntity :   JSON 형식을 변환해서 내보냄. + HTTP 상태 코드를 내보낼 수 있다. 
		//    data + http 상태코드 를 리턴 , 클라이언트에서 좀더 세밀한 컨트롤을 할 수 있음. 
	@PostMapping("/ex09")
	public ResponseEntity ex09(
			@RequestBody AjaxDto ajaxDto
			){
		System.out.println("ex09 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		return new ResponseEntity<>(ajaxDto, HttpStatus.OK); 
		//return new ResponseEntity<>(ajaxDto, HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/ex10") 
	public ResponseEntity ex10 (
			@RequestBody AjaxDto ajaxDto
			) {
		System.out.println("ex10 요청 성공 !!! ");
		System.out.println("Dto param1 의 값 : " + ajaxDto.getParam1());
		System.out.println("Dto param2 의 값 : " + ajaxDto.getParam2());
		
		List<AjaxDto> dtoList = new ArrayList(); 
		
		dtoList.add(ajaxDto); 
		dtoList.add(new AjaxDto("사과", "배")); 
		dtoList.add(new AjaxDto("딸기", "바나나")); 
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK); 
	//	return new ResponseEntity<>(dtoList, HttpStatus.UNAUTHORIZED);
		
	}
	
	// DI 객체 주입 : @RequiredArgsConstructor 
	private final MovieService movieService ; 
	
	// Movie 의 POST 요청을 처리하는 메소드 : insert 
	@PostMapping("/movie") 
	public ResponseEntity<String> movieInsert(
			// cliet 에서 던지는 객체를 자바에서 input 
			@RequestBody MovieDTO movieDTO 
			) {
		System.out.println("=====================");
		System.out.println(movieDTO.getBackdrop_path());
		System.out.println(movieDTO.getOriginal_language());
		System.out.println(movieDTO.getTitle());
		System.out.println(movieDTO.getPoster_path());
		System.out.println("=====================");
		
		
		String complate = movieService.movieInsert(movieDTO) ; 
		
		return new ResponseEntity<String>( complate , HttpStatus.OK); 
	}
	
	// get , movie 테이블의 전체 내용을 출력 
	@GetMapping("/movie") 
	public ResponseEntity<List<MovieDTO>> getMovieAll() {
		System.out.println("/movie 요청 잘 받음!!!");
		
		List<MovieDTO> movieList = movieService.selectAll(); 
				
		return new ResponseEntity<> ( movieList, HttpStatus.OK); 
	}

	
	
	

	
	
	
	
	

}

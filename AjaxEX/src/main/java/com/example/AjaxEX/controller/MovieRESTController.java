package com.example.AjaxEX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AjaxEX.dto.MovieDTO;
import com.example.AjaxEX.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController     // @ResposeBody +  @Controller  : 메소드에서 리턴되는 모든 타입은 JSON, 
					// swagger : API 문서를 자동으로 생성   
public class MovieRESTController {
	/*
	 REST API  : URL 에 동사를 사용 하지 않는다. 
	 //  swagger 라이브러러 : @RestController 하위의 메소드의 요청 주소를 게더링 해서 API 문서를 자동으로 생성 
	 
	 
	  GET	:  /movie		: selectAll	, 리턴 :  [{}, {}, {}]	,  List<Movie> , Page<Movie> 
	  GET   :  /movie/1		: select ,    리턴  : {},  Movie
	  POST  :  /movie       : insert , data(서버로 insert 값 전송할, JSON)  리턴 (x) 
	  PUT   :  /movie/1     : update (모든컬럼) , data(서버로 update 값 전송할, JSON)  리턴 (x) 
	  DELETE : /movie/1     : delete  
	 
	 */
	

	// DI 객체 주입 : @RequiredArgsConstructor 
	private final MovieService movieService ; 
	
	// Movie 의 POST 요청을 처리하는 메소드 : insert 
	@PostMapping("/movie") 
	public ResponseEntity<String> movieInsert(
			// client 에서 던지는 객체를 자바에서 input 
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
	
	// 수정 로직 : put , /movie/{id} 
	@PutMapping("/movie/{id}")
	public ResponseEntity updateMovie(
			@PathVariable("id") long id , 
			@RequestBody MovieDTO movieDTO 
			) {
//		System.out.println("put 요청 처럼됨 ");
//		System.out.println(id);
//		System.out.println(movieDTO.getTitle());
		
		movieService.updateMovie(id, movieDTO); 
		
		
		return ResponseEntity.ok(movieDTO); 
	}

	// 삭제 : delete , /movie/{id}
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<String> deleteMovie (
			@PathVariable("id") long id 
			) {
		System.out.println("delete 요청 성공 : " + id );
		
		movieService.deleteMovie(id); 
		
		
	//	return ResponseEntity.ok("서버에서 삭제 성공됨"); 
		return new ResponseEntity("서버에서 삭제 성공", HttpStatus.OK ); 
		
	}
	
	// 글 상세 내용 보기 , get, /movie/{id}
	@GetMapping("/movie/{id}")
	public ResponseEntity<MovieDTO> getDetail (
			@PathVariable("id") long id 
			) {
		//System.out.println("상세보기 요청 성공 : " + id);
		
		MovieDTO movieDTO = movieService.getMovieDetail(id); 
		
		return ResponseEntity.ok(movieDTO); 
	}
	

	
	
	
}

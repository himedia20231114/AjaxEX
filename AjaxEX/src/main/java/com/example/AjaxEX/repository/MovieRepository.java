package com.example.AjaxEX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AjaxEX.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	// SQL 쿼리를 자바의 메소드를 사용해서 처리 
	// 
	/*
	 *  findAll() 	: DB의 Movie 테이블의 모든 레코드     List<Movie>   
	 *  findById()  : DB의 Movie 테이블의 하나의 레코드 	 Optional<Movie> 
	 *  save()      : DB의 Movie 테이블의 값을 Insert, Update(끄집어내서, 수정후)  
	 *  delete()    : DB의 Movie 테이블의 레코드 삭제 
	 */
}

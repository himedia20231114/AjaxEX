package com.example.AjaxEX.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AjaxDto {
	
	// 기본 생성자가 반드시 존재 해야 한다. 
	
	
	// client 에서 넘어오는 필드의 값을 받음 
	// server에서 처리된 결과를 client 엑게  보낼때 
	
	public AjaxDto (String data1, String data2) {
		param1 = data1 ; 
		param2 = data2 ; 
	}
	
	
	private String param1 ; 
	
	private String param2 ; 
	

	
	

}

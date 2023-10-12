package com.example.mybatisexam.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * packageName : com.example.mybatisexam.model.common
 * fileName : PageReq
 * author : L.DH
 * date : 2023-10-12
 * description : 공통 클래스(페이징 요청 클래스)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-12         L.DH         최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageReq {

	/** 현재 페이지 번호 : page == number */
	private int page;

	/** 페이지당 출력할 데이터 개수 */
	private int size;

//	offset 개수 : 1st 데이터로 부터 얼마나 떨어져 있는지 개수
//	private Integer offset = page * size;

	public PageReq(int page, int size) {
		this.page = page;
		this.size = size;
	}
}

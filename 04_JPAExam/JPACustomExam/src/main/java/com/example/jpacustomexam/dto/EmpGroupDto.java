package com.example.jpacustomexam.dto;

/**
 * packageName : com.example.jpacustomexam.dto
 * fileName : EmpGroupDto
 * author : L.DH
 * date : 2023-10-18
 * description : DTO 인터페이스(Emp Group 용)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * ———————————————————————————————
 * 2023-10-18         L.DH         최초 생성
 */
public interface EmpGroupDto {
//    속성 (상수) x
//    연습 5) getter 함수 : dno(Integer), job(String), salary(Integer)
    Integer getDno();

    String getJob();

    Integer getSalary();

    //    연습 6) DNO, avgSalary(Integer)
    Integer getAvgSalary();

    //    연습 7) countEno(Integer), sumSalary(Integer)
    Integer getCountEno();
    Integer getSumSalary();

    //    연습 8) maxHiredate(String), minHiredate(Integer)
    String getMaxHiredate();
    String getMinHiredate();

} // end of interface

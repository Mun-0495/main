package com.example.Project1.Service.Interface;

import com.example.Project1.Model.SignupDTO;

//사인업 페이지의 인터페이스입니다.
//signupDTO 객체가 넘겨지면 이를 저장하는 메소드가 필요합니다.
public interface SignupService {
    boolean check(SignupDTO signupDTO);

    void save();
}

package com.example.Project1.Service.Interface;

import com.example.Project1.Model.LoginDTO;

//로그인 서비스의 인터페이스입니다.
//로그인을 하는 메소드가 필요합니다.
public interface LoginService {
    String login(LoginDTO loginDTO);
}

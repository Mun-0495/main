package com.example.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Project1.Service.Interface.LoginService;
import com.example.Project1.Service.Interface.SignupService;
import com.example.Project1.Model.LoginDTO;

import jakarta.servlet.http.HttpSession;

import com.example.Project1.Model.SignupDTO;

import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/api/user") //API가 불러져 왔을 때 입니다. 즉 api 주소로 받겠다는 의미입니다. localhost:8080/api
@RequiredArgsConstructor
public class UserController {

    //생성자를 주입합니다.
    //이때 로직을 처리하기 위한 서비스 패키지에서 생성자를 추가하여 사용합니다.
    private final SignupService signupService;
    private final LoginService loginService;

    @GetMapping("/signup")
    public String signupForm() {
        return "signup.html";
    }

    @PostMapping(value="/signup")
    public String signup(@ModelAttribute SignupDTO signupDTO) {
        //TODO: process POST request
        System.out.println("User Sign Up");
        signupService.save(signupDTO);
        
        return "login.html";
    }

    @GetMapping(value="/login")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession httpSession) {
        if(loginService.login(loginDTO)) {
            httpSession.setAttribute("loginEmail", loginDTO.getEmail()); //login session 할당.
            System.out.println(httpSession.getAttribute("loginEmail"));
            return "/home";
        }
        return "login.html";
    }
    
}
    

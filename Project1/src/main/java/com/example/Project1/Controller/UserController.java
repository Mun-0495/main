package com.example.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Project1.Service.Interface.LoginService;
import com.example.Project1.Service.Interface.SignupService;

import jakarta.servlet.http.HttpSession;

import com.example.Project1.Model.LoginDTO;

import com.example.Project1.Model.SignupDTO;

import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/api/user") //API가 불러져 왔을 때 입니다. 즉 api 주소로 받겠다는 의미입니다. localhost:8080/api
@RequiredArgsConstructor
public class UserController {

    /*
     *  세션이 들어갈만한 모든 내용을 미들웨어를 호출함으로써 해결해봅시다.
     *  미들웨어의 세션클래스를 이용해 대체할 건 대체하고, 그렇게 할 경우 더 비효율적이라면 변경하지 않도록 합시다.
     *  지금 당장 해야할 건 아니고, 순차적으로 차차 대체해보겠습니다.
     */

    //생성자를 주입합니다.
    //이때 로직을 처리하기 위한 서비스 패키지에서 생성자를 추가하여 사용합니다.
    private final SignupService signupService;
    private final LoginService loginService;

    @GetMapping("/signup")
    public String signupForm() {
        return "signup.html";
    }

    //새로운 유저를 등록합니다.
    //만약 기존 유저가 있다면 기존에 있는 유저라고 정보를 띄워줍니다. 
    //새로운 유저라면 저장해줍니다.
    @PostMapping(value="/signup")
    public String signup(@ModelAttribute SignupDTO signupDTO) {
        if(signupService.check(signupDTO)) {
            System.out.println("User Sign Up");
            signupService.save();
        }
        else System.out.println("이미 있는 회원입니다.");

        return "login.html";
    }

    @GetMapping(value="/login")
    public String loginForm(@ModelAttribute HttpSession httpSession) {
        //로그인 할 때 세션을 체크합니다.
        return "login.html";
    }


    //로그인을 하는 과정입니다.
    //포스트 맵핑으로 데이터를 받아오면, 그 데이터를 기반으로 로그인을 진행합니다.
    //이떄 데이터는 loginDTO의 객체를 받아옵니다.
    //로그인 후에 세션을 저장해줍니다.
    //만약 로그인이 실패했다면 다시 로그인 화면으로 돌아갑니다.
    @PostMapping(value = "/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession httpSession) {
        String status = loginService.login(loginDTO);
        if(status != null) {
            httpSession.setAttribute("USER", status);
            System.out.println("현재 유저 " + httpSession.getAttribute("USER"));
            return "/home";
        }
        return "login.html";
    }


    
}
    

package com.example.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Project1.Model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/api/*/board")
public class BoardController {
    //CREATE
    @GetMapping("/write")
    public String write_page(@ModelAttribute UserDTO user) {
        //유저 확인하고 권한 줘야함
        //만약 그 유저가 GUEST라면 권한을 못줌
        if(user.getUsername().equals("GUEST")) {
            return "login.html";
        }
        //이때 유저 정보도 같이 줘야하는지 확인해봅니다.
        //만약 유저 정보를 줘야 한다면 유저 정보를 넘겨줍니다.
        return "boardwrite.html";
    }

    
    //READ

    //UPDATE

    //DELETE
}

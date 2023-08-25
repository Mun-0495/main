package com.example.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class HomeController {
    
    // @RequestMapping
    // public String indexpage() {
    //     return "index.html";
    // }

    //홈 화면입니다.
    //로그인 버튼과 게시글이 있어야 합니다.
    //프론트에서 로그인 된 상황과 로그아웃된 상황을 보여줘야 합니다.
    //프론트에서 해줄 일.
    //TODO : 게시판 보이는거, 게시글 제목 | 작성자(유저네임) | 작성시간 | 조회수
    //TODO : 저 형식으로 있어야 합니다. 글쓰기 버튼과 로그인 되어있는지 안되어있는지 확인되어야 합니다.
    //TODO : 각 글마다 수정하기 버튼 있으면 좋겠습니다.
    //TODO : 게시글 제목에는 하이퍼링크가 되어있어야 합니다.
    @GetMapping(value="/board")
    public String getMethodName(@RequestParam String param) {
        return "board.html";
    }
    
}

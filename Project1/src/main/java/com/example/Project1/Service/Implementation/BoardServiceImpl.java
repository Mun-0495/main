package com.example.Project1.Service.Implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Project1.Model.BoardDTO;
import com.example.Project1.Service.Interface.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    //글을 씁니다. 
    //이 글을 쓰는 공간은 빈 공간입니다.
    //저장하기 버튼을 누르면 내가 쓰는 글의 내용이 그대로 리턴값으로 반환되어야 합니다.
    //이때 제목과 본문을 함께 묶어서 보냅니다.
    String write() {

    }

    //글을 수정합니다.
    //이 글을 쓰는 공간엔 기존엔 썼던 글이 그대로 남아있어야 합니다.
    //저장하기 버튼을 누르면 새롭게 수정한 내용이 다시 리턴값으로 반환됩니다.
    //제목은 수정할 수 없습니다.
    String modify(@ModelAttribute BoardDTO board) {

    }
}

package com.example.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.Project1.Model.BoardDTO;
import com.example.Project1.Service.Implementation.BoardServiceImpl;

import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    /*
     *  세션이 들어갈만한 모든 내용을 미들웨어를 호출함으로써 해결해봅시다.
     *  미들웨어의 세션클래스를 이용해 대체할 건 대체하고, 그렇게 할 경우 더 비효율적이라면 변경하지 않도록 합시다.
     *  지금 당장 해야할 건 아니고, 순차적으로 차차 대체해보겠습니다.
     */

    private final BoardServiceImpl boardServiceImpl;

    //CREATE
    //글을 써서 정보를 넘겨주는 화면입니다.
    //인자로 글 제목과 글 내용을 포함해야만 합니다.
    //받은 글 제목과 글 내용은 하나의 객체로 담아서 보내줍니다.
    //보낸 내용은 업데이트하는 api로 이동합니다.
    //boardwrite에서 글을 저장하는 버튼을 누르면 업데이트 하는 창으로 가야합니다.
    @GetMapping("/write")
    public String write_page() {
        //유저 확인하고 권한 줘야함
        //만약 그 유저가 GUEST라면 권한을 못줌
        //내가 가지고 있는 이 세션의 로그인 정보가 GUEST라면 로그인 화면으로 돌아갑니다.
        //만약 내가 가지고 있는 이 세션의 로그인 정보가 디비에 있는 유저의 정보와 동일하다면 업데이트 화면으로 갑니다.

        //세션의 정보를 확인할 때 미리 만들어놓은 미들웨어를 사용합니다.
        //정보를 찾아서 게스트라면 로그인 화면으로 돌아갑니다.
        //null이라면 로그인 화면으로 돌아갑니다.
        //회원이라면 글쓰기 화면으로 넘어갑니다.
        
        //이때 유저 정보도 같이 줘야하는지 확인해봅니다.
        //만약 유저 정보를 줘야 한다면 유저 정보를 넘겨줍니다.


        return "boardwrite.html";
    }


    //글을 업데이트하는 api입니다.             
    //업데이트 하는 쪽에서 버튼을 누르면 정보를 받아서 글을 디비에 저장합니다.
    //저장한 다음 다시 보드 화면으로 돌아갑니다.
    //객체를 파라미터로 받습니다. 그걸 그대로 저장합니다.
    //boardDTO에서는 글 유저와 글 제목만 전달 받습니다. 유저는 현재 세션의 정보에서 가져와 저장합니다.
    @PostMapping("/write")
    public String write_update(@ModelAttribute BoardDTO boardDTO, HttpSession httpSession) {
        String user = (String)httpSession.getAttribute("USER");
        boardDTO.setUser(user);
        boardServiceImpl.update(boardDTO);
        
        return "board.html";
    }


    //MODIFY
    //글을 수정하는 api입니다.
    //현재 세션에 들어있는 유저 정보와 수정하려는 글의 유저 정보가 일치해야 합니다.
    //일치한다면 정보를 수정하는 창으로 갑니다.
    //그렇지 않다면 다시 되돌아 갑니다.
    @GetMapping("/modify")
    public String modify_go(@ModelAttribute BoardDTO boardDTO, HttpSession httpSession) {
        String user = (String)httpSession.getAttribute("USER");
        if(!boardDTO.getUser().equals(user)) {
            System.out.println("같은 유저가 아닙니다!");
            return "re:direct/home.html";
        }
        return "board.html";
    }
    
    @PutMapping("/modify")
    public String modify_do(@ModelAttribute BoardDTO boardDTO) {
        boardServiceImpl.update(boardDTO);
        return "board.html";
    }


    //DELETE
    //글을 삭제하는 api입니다.
    //유저 정보를 확인한 후, 유저 정보가 맞다면 기존 디비에서 글을 지웁니다.
    //그렇지 않다면 권한이 없다고 말해준 뒤 다시 제자리로 돌아갑니다.
    @DeleteMapping("/delete")
    public String delete_go(@ModelAttribute BoardDTO boardDTO, HttpSession httpSession) {
        String user = (String)httpSession.getAttribute("USER");
        if(boardDTO.getUser().equals(user)) {
            System.out.println("권한이 없습니다!");
            return "board.html";
        }
        boardServiceImpl.delete(boardDTO);
        return "board.html";
    }


    //조회수를 증가시키는 api입니다.
    //글로 들어갈 때 마다 조회수가 하나씩 증가되고, 이는 기존 디비에서 반영이 됩니다.

}

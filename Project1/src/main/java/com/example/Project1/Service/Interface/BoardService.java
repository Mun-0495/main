package com.example.Project1.Service.Interface;

import com.example.Project1.Model.BoardDTO;

//import jakarta.servlet.http.HttpSession;

public interface BoardService {

    void update(BoardDTO boardDTO);

    void delete(BoardDTO boardDTO);

    //void countup(BoardDTO boardDTO, HttpSession httpSession);

}

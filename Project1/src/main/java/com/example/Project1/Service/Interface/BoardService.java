package com.example.Project1.Service.Interface;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Project1.Model.UserDTO;
import com.example.Project1.Model.BoardDTO;

public interface BoardService {


    String write();

    String modify(@ModelAttribute BoardDTO board);
}

package com.example.Project1.Entity;

import java.sql.Date;

import com.example.Project1.Model.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "BOARD")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String user;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Date date;

    @Column
    private int view;

    public static BoardEntity toBoardEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setBody(boardDTO.getBody());
        boardEntity.setUser(boardDTO.getUser());

        return boardEntity;
    }
    
}

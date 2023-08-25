package com.example.Project1.Service.Implementation;

import org.springframework.stereotype.Service;

import com.example.Project1.Entity.BoardEntity;
import com.example.Project1.Model.BoardDTO;
import com.example.Project1.Repository.BoardRepository;
import com.example.Project1.Service.Interface.BoardService;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardRepository boardRepository;

    //제목과 본문, 그리고 유저 내용이 담긴 정보가 그대로 이쪽으로 전달됩니다.
    //boardEntity에 저장을 해주고, 이걸 레퍼지토리의 save메소드를 저장합시다.
    //기존 디비에 내용을 추가하게 됩니다. 리턴값이 딱히 필요 없으므로 void로 지정합니다.
    public void update(BoardDTO boardDTO) {
        Date date = new Date();
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardEntity.setDate(new java.sql.Date(date.getTime())); //현재 시간을 등록해줍니다.
        boardEntity.setView(0);
        boardRepository.save(boardEntity);
    }

    //조회수를 올려주는 api가 필요합니다.
    //이 함수는 호출 될 때 마다, 조회수를 올려줍니다.
    //하지만 기존 사용자가 접속했다면 조회수를 올려주지 않습니다.
    //또, 글쓴이와 같은 사용자가 접속했다면 조회수를 올려주지 않습니다.
    // public void countup(BoardDTO boardDTO, HttpSession httpSession) {

    // }

    //글을 삭제해주는 api입니다.
    //이 함수는 호출되면 기존에 있던 글을 디비에서 삭제시켜줍니다.
    //이떄 게시글과 같은 유저가 아니라면 글은 삭제되지 않습니다. 이 작업은 컨트롤러에서 미리 거릅니다.
    //게시글을 삭제해줍니다.
    public void delete(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardRepository.findByUser(boardDTO.getUser());
        boardRepository.delete(boardEntity);
    }
}

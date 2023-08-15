package com.example.Project1.Service.Implementation;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import com.example.Project1.Entity.BoardEntity;
import com.example.Project1.Model.BoardDTO;
import com.example.Project1.Repository.BoardRepository;
import com.example.Project1.Service.Interface.BoardService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardRepository boardRepository;

    //제목과 본문, 그리고 유저 내용이 담긴 정보가 그대로 이쪽으로 전달됩니다.
    //boardEntity에 저장을 해주고, 이걸 레퍼지토리의 save메소드를 저장합시다.
    //기존 디비에 내용을 추가하게 됩니다. 리턴값이 딱히 필요 없으므로 void로 지정합니다.
    public void update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardEntity.setDatetime(null); //현재 시간을 등록해줍니다.
        boardEntity.setView(0);
        boardRepository.save(boardEntity);
    }

    
    //다시 제목과 본문, 그리고 유저 내용이 담긴 정보가 전달됩니다.
    //boardEntity에서 똑같은 이름을 지닌 사용자를 찾아서 기존 디비에서 수정해줍니다.
    //수정할 때 작성 시간 또한 변경되어야 하며, 유저 정보, 조회수는 변경되지 않습니다.
    //마찬가지로 딱히 리턴타입이 필요없으므로 void로 지정합니다.
    public void modify(BoardDTO boardDTO) {

    }
}

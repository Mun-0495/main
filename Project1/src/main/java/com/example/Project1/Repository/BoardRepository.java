package com.example.Project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project1.Entity.BoardEntity;
import java.util.List;


public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    //쿼리문을 작성합시다.
    //글을 수정하는 쿼리문을 작성해야 합니다.
    //기존 디비에서 글을 수정합니다.
    BoardEntity findByUser(String user);
}

package com.example.Project1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    //현재 유저의 정보는 세션의 정보에서 가져올거기 때문에 널로 설정해둡니다.
    private String user = null;

    private String title;
    private String body;
}

package com.example.Project1.MiddleWare;

import jakarta.servlet.http.HttpSession;

public class Session {
    private HttpSession httpSession;
    //특정한 일을 하는 미들웨어입니다.
    //거의 모든 함수에서 쓰이기에 이 함수를 만들어놓고 호출만 하면 코드를 자체적으로 줄여줍니다.
    //이건 세션이 없을 때 세션을 주는 미들웨어 입니다.
    
    //세션을 확인합니다.
    //세션이 없다면 GUEST세션을 줍니다.
    //세션이 있다면 기존 세션을 유지합니다.
    public boolean GUEST()
    
    //현재 세션과 유저 정보를 확인하고 이를 돌려줍니다.
    //이 함수는
}

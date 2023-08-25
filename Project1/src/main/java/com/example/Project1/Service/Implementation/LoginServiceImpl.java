package com.example.Project1.Service.Implementation;

import org.springframework.stereotype.Service;

import com.example.Project1.Entity.UserEntity;
import com.example.Project1.Model.LoginDTO;
import com.example.Project1.Repository.UserRepository;
import com.example.Project1.Service.Interface.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    //로그인 서비스 구현입니다.
    //로그인 객체를 불러와서 기존 디비와 비교합니다.
    //이때, 기존에 들어있는 디비와 비교해서 정보가 동일하다면 비밀번호를 비교합니다.
    //비밀번호가 맞다면 로그인 성공, 그렇지 않다면 실패입니다.
    //로그인 성공 시 홈화면으로 돌아갑니다. 그렇지 않다면 다시 로그인 창으로 머무릅니다.
    @Override
    public String login(LoginDTO loginDTO) {
        UserEntity userEntity = userRepository.findByEmail(loginDTO.getEmail());
        if(userEntity != null) {
            if(userEntity.getPassword().equals(loginDTO.getPassword())) 
                return userEntity.getUsername();
            //프론트에서 해줄 일
            //TODO : 로그인이 실패했다는 메시지를 띄워주어야 합니다.
            //TODO : 잘못된 비밀번호라고 띄어주어야 합니다.
            return null;
        }

        //TODO : 프론트에서 해줄 일 : 존재하지 않는 아이디라고 창을 띄워주어야 합니다.
        return null;
    }

    //

}
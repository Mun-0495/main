package com.example.Project1.Service.Implementation;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.Project1.Repository.UserRepository;
import com.example.Project1.Service.Interface.SignupService;
import com.example.Project1.Entity.UserEntity;
import com.example.Project1.Model.SignupDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
    private final UserRepository userRepository;
    private UserEntity userEntity = new UserEntity();

    //기존의 회원이 있는지 체크합니다.
    //만약 기존의 회원이 있다면 UserEntity의 값이 null이 되지 않습니다.
    //null이 아니라면 false, 맞다면 true를 반환합니다.
    @Override
    public boolean check(SignupDTO signupDTO) {
        if(userRepository.findByUsername(signupDTO.getUsername()) != null &&
        userRepository.findByEmail(signupDTO.getEmail()) != null && 
        userRepository.findByPhone(signupDTO.getPhone()) != null) return false;
        
        userEntity = UserEntity.toUserEntity(signupDTO);
        return true;
    }


    //회원의 정보를 저장해줍니다.
    //save를 활용해 그대로 저장해줍니다.
    @Override
    public void save() {
        userRepository.save(userEntity);
    }

    
}

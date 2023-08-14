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
    
    @Override
    public int save(SignupDTO signupDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(signupDTO);
        int id = userRepository.save(userEntity).getId();

        return id;
    }
}

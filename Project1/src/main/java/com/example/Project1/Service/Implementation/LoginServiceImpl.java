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

    @Override
    public boolean login(LoginDTO loginDTO) {
        UserEntity userEntity = userRepository.findByEmail(loginDTO.getEmail());

        if(userEntity != null) {
            if(userEntity.getPassword().equals(loginDTO.getPassword())) return true;
            return false;
        }
        
        return false;
    }


}
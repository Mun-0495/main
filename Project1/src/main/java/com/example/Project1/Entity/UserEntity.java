package com.example.Project1.Entity;

import com.example.Project1.Model.SignupDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //DB테이블에 대응하는 하나의 클래스 어노테이션입니다. JPA가 관리해줍니다.
@Setter
@Getter
@Table(name = "USER") //원하는 테이블과 맵핑합니다.
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 30)
    private String email;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String phone;

    public static UserEntity toUserEntity(SignupDTO signupDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(signupDTO.getEmail());
        userEntity.setPassword(signupDTO.getPassword());
        userEntity.setPhone(signupDTO.getPhone());
        userEntity.setUsername(signupDTO.getUsername());
    
        return userEntity;
    }
}

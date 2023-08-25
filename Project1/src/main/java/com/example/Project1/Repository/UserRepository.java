package com.example.Project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project1.Entity.UserEntity;


//Repository는 쿼리를 특정 문자들의 조합으로 간단하게 쓸 수 있는 인터페이스입니다.

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    //findBy(객체명)을 통해 기존 디비에 들어있는 값을 조회해줍니다.
    //로그인 과정에서 활용하기 때문에 UserEntity에서 정보를 조회합니다.
    //이메일, 폰번호, 유저네임 중 하나라도 일치하는 경우 사인업이 안되기 때문에 세개를 써줍니다.
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity findByPhone(String phone);

}

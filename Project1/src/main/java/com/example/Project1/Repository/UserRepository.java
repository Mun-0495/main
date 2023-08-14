package com.example.Project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project1.Entity.UserEntity;

//Repository는 쿼리를 모아둔 느낌이 강합니다.
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
}

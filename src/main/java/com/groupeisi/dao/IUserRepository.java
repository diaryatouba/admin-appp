package com.groupeisi.dao;

import com.groupeisi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}

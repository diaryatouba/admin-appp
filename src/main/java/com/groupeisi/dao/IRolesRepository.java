package com.groupeisi.dao;

import com.groupeisi.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<RoleEntity, Integer> {
}

package com.groupeisi.dao;


import com.groupeisi.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<ProduitEntity, Integer> {
}

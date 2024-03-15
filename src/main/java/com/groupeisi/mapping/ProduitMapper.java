package com.groupeisi.mapping;

import org.mapstruct.Mapper;
import com.groupeisi.dto.ProduitDto;
import com.groupeisi.entities.ProduitEntity;


@Mapper
public interface ProduitMapper {
    ProduitDto toProduitDto(ProduitEntity produitEntity);
    ProduitEntity fromProduitDto(ProduitDto produitDto);
}

package com.groupeisi.mapping;

import com.groupeisi.entities.RoleEntity;
import org.mapstruct.Mapper;
import com.groupeisi.dto.RoleDto;

@Mapper
public interface RolesMapper {
    RoleDto toRoleDto(RoleEntity roleEntity);
    RoleEntity fromRoleDto(RoleDto roleDto);
}

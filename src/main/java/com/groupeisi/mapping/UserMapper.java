package com.groupeisi.mapping;

import com.groupeisi.entities.UserEntity;
import org.mapstruct.Mapper;
import com.groupeisi.dto.UserDto;

@Mapper
public interface UserMapper {
    UserDto toUserDto(UserEntity userEntity);
    UserEntity fromUserDto(UserDto userDto);
}

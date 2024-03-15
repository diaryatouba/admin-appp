package com.groupeisi.services;

import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.groupeisi.dao.IUserRepository;
import com.groupeisi.dto.UserDto;
import com.groupeisi.mapping.UserMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class UserService {
    private IUserRepository iUserRepository;
    private UserMapper userMapper;
    MessageSource messageSource;

    public UserService(IUserRepository iUserRepository, UserMapper userMapper, MessageSource messageSource) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<UserDto> getUsers() {
        log.info("liste des utilisateur avec ");

        return StreamSupport.stream(iUserRepository.findAll().spliterator(), false)
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto getUsers(int id) {
        log.info("Recherche de l'utilisateur avec l'ID : {}", id);
        return userMapper.toUserDto(iUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }
    @Transactional
    public UserDto createUsers(UserDto userDto) {
        return userMapper.toUserDto(iUserRepository.save(userMapper.fromUserDto(userDto)));
    }

    @Transactional
    public UserDto updateUsers(int id, UserDto userDto) {
        return iUserRepository.findById(id)
                .map(entity -> {
                    userDto.setId(id);
                    return userMapper.toUserDto(
                            iUserRepository.save(userMapper.fromUserDto(userDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteUsers(int id) {
        try {
            iUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}

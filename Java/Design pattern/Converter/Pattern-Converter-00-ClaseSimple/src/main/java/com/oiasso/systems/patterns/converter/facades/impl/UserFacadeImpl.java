package com.oiasso.systems.patterns.converter.facades.impl;

import com.oiasso.systems.patterns.converter.converters.UserConverter;
import com.oiasso.systems.patterns.converter.daos.UserDao;
import com.oiasso.systems.patterns.converter.daos.impl.UserDaoImpl;
import com.oiasso.systems.patterns.converter.dtos.UserDTO;
import com.oiasso.systems.patterns.converter.entitys.UserEntity;
import com.oiasso.systems.patterns.converter.facades.UserFacade;

/*
 * UserFacadeImpl
 */
public class UserFacadeImpl implements UserFacade {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserDTO findUserByUsername(String username) {        
        UserEntity userEntity = userDao.findUserByUsername(username);
        UserConverter converter = new UserConverter();
        return converter.fromEntity(userEntity);
    }

    @Override
    public void save(UserDTO userDto) {
        UserConverter converter = new UserConverter();
        UserEntity userEntity = converter.fromDto(userDto);
        userDao.save(userEntity);
    }

}
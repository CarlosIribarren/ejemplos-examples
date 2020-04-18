package com.oiasso.systems.patterns.converter.facades;

import java.util.List;

import com.oiasso.systems.patterns.converter.dtos.UserDTO;

/**
 * UserFacade
 */
public interface UserFacade {

    public List<UserDTO> findAllUsers();

    UserDTO findUserByUsername(String username);

    public void save(UserDTO userDto);
}
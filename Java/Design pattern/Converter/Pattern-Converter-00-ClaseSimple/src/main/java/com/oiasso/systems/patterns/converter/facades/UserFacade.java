package com.oiasso.systems.patterns.converter.facades;

import com.oiasso.systems.patterns.converter.dtos.UserDTO;

/**
 * UserFacade
 */
public interface UserFacade {

    UserDTO findUserByUsername(String username);

    public void save(UserDTO userDto);
}
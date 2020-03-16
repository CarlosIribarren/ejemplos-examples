package com.oiasso.systems.patterns.converter.daos;

import com.oiasso.systems.patterns.converter.entitys.UserEntity;

/**
 * UserDao
 */
public interface UserDao {

    UserEntity findUserByUsername(String username);

	void save(UserEntity userEntity);
}
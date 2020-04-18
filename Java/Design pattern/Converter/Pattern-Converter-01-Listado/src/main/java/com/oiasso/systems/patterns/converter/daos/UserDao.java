package com.oiasso.systems.patterns.converter.daos;

import java.util.List;

import com.oiasso.systems.patterns.converter.entitys.UserEntity;

/**
 * UserDao
 */
public interface UserDao {

    UserEntity findUserByUsername(String username);

	void save(UserEntity userEntity);

	List<UserEntity> findAllUsers();
}
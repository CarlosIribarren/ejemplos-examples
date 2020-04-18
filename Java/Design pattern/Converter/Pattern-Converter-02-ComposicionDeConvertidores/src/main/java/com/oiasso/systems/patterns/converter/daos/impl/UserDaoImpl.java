package com.oiasso.systems.patterns.converter.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.oiasso.systems.patterns.converter.daos.UserDao;
import com.oiasso.systems.patterns.converter.entitys.RolEntity;
import com.oiasso.systems.patterns.converter.entitys.UserEntity;

/**
 * UserDaoImpl Se simula la capa de persistencia
 */
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity findUserByUsername(String username) {

        UserEntity userEntity = null;
        if (username.equals("admin")) {
            userEntity = new UserEntity(new Integer(1), "admin", "admin", new RolEntity(1, "ROLE_ADMIN"));
        }
        return userEntity;
    }

    @Override
    public void save(UserEntity userEntity) {

        System.out.println("Entity para guardar en BD");
        System.out.println("-------------------------");

        System.out.println("User Id: " + userEntity.getId());
        System.out.println("Username: " + userEntity.getUsername());
        System.out.println("Password: " + userEntity.getPassword());

        RolEntity rolEntity = userEntity.getRole();
        System.out.println("Rol Id: " + rolEntity.getId());
        System.out.println("Rol name: " + rolEntity.getName());

    }

    @Override
    public List<UserEntity> findAllUsers() {
        List<UserEntity> allUsers = new ArrayList<>();
        UserEntity userEntityAdmin = new UserEntity(new Integer(1), "admin", "admin", new RolEntity(1, "ROLE_ADMIN"));
        UserEntity userEntityOperator = new UserEntity(new Integer(2), "operator", "operator", new RolEntity(2, "ROLE_OPERATOR"));
        allUsers.add(userEntityAdmin);
        allUsers.add(userEntityOperator);
        return allUsers;
    }

}
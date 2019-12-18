package com.sample.test.service;

import com.sample.test.common.entity.User;
import com.sample.test.common.exception.ServiceException;
import java.util.List;

public interface UserService {

    public List<User> getAllUsers() throws ServiceException;

    public void add(User user) throws ServiceException;

    public User getUserById(Integer id) throws ServiceException;

    public Integer updateUsernameById(String username, int id) throws ServiceException;

    public void deleteByUserById(Integer uid) throws ServiceException;

    public User selectByName(String name) throws ServiceException;

    public List<User> selectByNameLike(String name) throws ServiceException;

     /*public User selectByEmName(String name) throws ServiceException;

     public void addByEm(User user) throws ServiceException;*/
}

/**
 * FileName: UserServiceImpl
 * Author:   huang.yj
 * Date:     2019/12/14 22:57
 * Description:
 */
package com.sample.test.service;

import com.sample.test.common.entity.User;
import com.sample.test.common.exception.ServiceException;
import com.sample.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author huang.yj
 * @create 2019/12/14
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void add(User user) throws ServiceException {
        try {
            userDao.save(user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public User getUserById(Integer id) throws ServiceException {
        try {
            Optional<User> optional = userDao.findById(id);
            return optional.orElse(null);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
    public Integer updateUsernameById(String username, int id) throws ServiceException {
        try {
            int result = userDao.updateUsernameById(username, id);
            return result;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
    public void deleteByUserById(Integer uid) throws ServiceException {
        try {
            userDao.deleteByUserById(uid);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public User selectByName(String name) throws ServiceException {
        try {
            return userDao.selectByName(name);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> selectByNameLike(String name) throws ServiceException {
        try {
            return userDao.selectByNameLike(name);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
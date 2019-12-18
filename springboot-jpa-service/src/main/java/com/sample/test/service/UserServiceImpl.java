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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
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

    // 1. 使用@PersistenceContext而不是使用@Resource，表示注入的是实体管理器，执行持久化操作的
    // 2. 虽然每个JPA规范的EntityManager都不是线程安全的,但@PersistenceContext确保将使用当前事务的entityManager，因为通过Spring注入的是代理的EntityManager，非EntityManager本身
    // 3. 一般springboot整合JPA是不需要自己注入EntityManager来使用的，此处是为了演示万一日后遇到通过EntityManager来操作数据库的，故注释了
    /*@PersistenceContext
    private EntityManager em;*/

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

    /**
     *@描述 演示EntityManager的使用
     *@参数  [name]
     *@返回值  com.sample.test.common.entity.User
     *@创建人  huang.yj
     *@创建时间  2019/12/18
     */
    /*@Override
    public User selectByEmName(String name) throws ServiceException {
        try {
            Query query = em.createQuery("select u from User as u where u.userName = :userName");
            query.setParameter("userName", name);
            List result = query.getResultList();
            Iterator iterator = result.iterator();
            while( iterator.hasNext() ){
                User user = (User) iterator.next();
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }*/

    /**
     *@描述 演示EntityManager的使用
     *@参数  [user]
     *@返回值  void
     *@创建人  huang.yj
     *@创建时间  2019/12/18
     */
   /* @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
    public void addByEm(User user) throws ServiceException {
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }*/
}
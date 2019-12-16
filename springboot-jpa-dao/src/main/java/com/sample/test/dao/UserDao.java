package com.sample.test.dao;

import com.sample.test.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    @Modifying
    @Query(value = "update test_user set user_name = :username where id = :userId",nativeQuery = true)
    public Integer updateUsernameById(String username, @Param("userId") int id);

    @Modifying
    @Query(value = "delete from test_user where id= ?1", nativeQuery = true)
    public void deleteByUserById(Integer uid);

    /**
     * 自定义模糊查询的使用
     * @param name
     * @return
     */
    @Query(value = "SELECT * FROM test_user WHERE user_name LIKE %?1%", nativeQuery = true)
    public List<User> selectByNameLike(String name);

    /**
     * 使用@NamedQuery进行方法查询
     * @param name 分类名称
     * @return category
     */
    public User selectByName(String name);
}

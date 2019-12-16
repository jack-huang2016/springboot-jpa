/**
 * FileName: User
 * Author:   huang.yj
 * Date:     2019/11/12 17:11
 * Description: 用户实体类
 */
package com.sample.test.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 〈用户实体类〉
 *  使用JPA注解配置映射关系
 * @author huang.yj
 * @create 2019/11/12
 * @since 0.0.1
 */
@Data
@Entity // 告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="test_user")  // @Table来指定和哪个数据表对应，如果省略默认表名就是该类名首字母小写；
// 命名查询（不太常用，使用的是JPQL），@NamedQuery只适合命名一个接口， 如果要定义多个命名查询，需要使用@NamedQueries。
@NamedQuery(name = "User.selectByName",query = "SELECT u FROM User u WHERE u.userName = ?1 ")
// 定义多个命名查询（不太常用，使用的是JPQL）
/*@NamedQueries({
        @NamedQuery(name="findAllUser",query="SELECT u FROM User u"),
        @NamedQuery(name="findUserWithId",query="SELECT u FROM User u WHERE u.id = ?1"),
        @NamedQuery(name="findUserWithName",query="SELECT u FROM User u WHERE u.name = :name")
})*/
public class User {

    @Id // 这是一个主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)  // 自增主键
    private int id;

    private String password;

    private String remarks;

    @Column(name="user_name")
    private String userName;

    private String email;

    private String phone;

    private int status;

    @Column(name="isLocked", length = 1)
    private int isLocked;

    @Column(name="update_time")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @Column(name="create_time")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}
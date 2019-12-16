/**
 * FileName: UserController
 * Author:   huang.yj
 * Date:     2019/12/14 23:17
 * Description:
 */
package com.sample.test.web;

import com.sample.test.common.entity.User;
import com.sample.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈〉
 *
 * @author huang.yj
 * @create 2019/12/14
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            List<User> list = userService.getAllUsers();
            // 成功，响应200
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<Void> addUser(User user){
        try {
            userService.add(user);
            // 成功，响应200
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(Integer id){
        try {
            User user = userService.getUserById(id);
            // 成功，响应200
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateUsernameById")
    public ResponseEntity<Void> updateUsernameById(String username, int id){
        try {
            userService.updateUsernameById(username, id);
            // 成功，响应200
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/deleteByUserById")
    public ResponseEntity<Void> deleteByUserById(int id){
        try {
            userService.deleteByUserById(id);
            // 成功，响应200
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/selectByName")
    public ResponseEntity<User> selectByName(String name){
        try {
            User user = userService.selectByName(name);
            // 成功，响应200
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/selectByNameLike")
    public ResponseEntity<List<User>> selectByNameLike(String name){
        try {
            List<User> list = userService.selectByNameLike(name);
            // 成功，响应200
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
            // 出错，响应500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
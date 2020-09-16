package com.ie.education;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ie.education.entity.User;
import com.ie.education.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
@Slf4j
@SpringBootTest
public class UserCRUD {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("yerenlong");
        user.setAge(30);
        user.setEmail("yeren@163.com");

        int row = userMapper.insert(user);
        log.info("row:{}", row);

    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1272882671722233858L);
        user.setAge(22);
        user.setUpdateTime(new Date());

        int row = userMapper.updateById(user);
        log.info("row:{}", row);
    }

    @Test
    public void selectBatchById() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        for(User user : users) {
            log.info(user.toString());
        }
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 28);
        List<User> users = userMapper.selectByMap(map);
        for(User user : users) {
            log.info(user.toString());
        }
    }

    @Test
    public void selectPage() {
        Page<User> page = new Page<>(2, 2);
        userMapper.selectPage(page,null);
        List<User> records = page.getRecords();
        for (User user : records) {
            log.info(user.toString());
        }
        log.info("总记录为：{}", page.getTotal());
    }

    @Test
    public void selectMapsPage() {
        Page<Map<String, Object>> page = new Page<>(1, 5);
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.select("name", "age");
        Page<Map<String, Object>> mapPage = userMapper.selectMapsPage(page, queryWrapper);
        List<Map<String, Object>> records = page.getRecords();
        for (Map<String, Object> map : records) {
            log.info(map.toString());
        }
        log.info("总记录为：{}", page.getTotal());
    }

    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(9L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(6, 7, 8));
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 30);
        int row = userMapper.deleteByMap(map);
        log.info("影响的记录条数为:{}", row);
    }

    @Test
    public void testLogicDelete() {
        int row = userMapper.deleteById(6L);
        log.info("影响的记录条数为:{}", row);
    }

}

package com.ie.education;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ie.education.entity.User;
import com.ie.education.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

    }

}

package com.ie.education;

import com.ie.education.entity.Product;
import com.ie.education.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ProductCRUD {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testUpdate() {

        Product p1 = productMapper.selectById(1L);
        Product p2 = productMapper.selectById(1L);

        p1.setPrice(p1.getPrice() + 50);
        int row1 = productMapper.updateById(p1);
        log.info("row1:{}", row1);

        p2.setPrice(p2.getPrice() - 30);
        int row2 = productMapper.updateById(p2);
        log.info("row2:{}", row2);

        if(row2 == 0) {
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            int row3 = productMapper.updateById(p2);
            log.info("row3:{}", row3);
        }

    }

}

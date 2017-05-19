package com.imoc.service;

import com.imoc.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/19
 * @Time : 14:52
 * @Description :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findById() throws Exception {
        Girl girl = girlService.findById(8);
        Assert.assertEquals(new Integer(13),girl.getAge());
    }

}
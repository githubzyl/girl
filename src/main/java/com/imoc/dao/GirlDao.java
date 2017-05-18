package com.imoc.dao;

import com.imoc.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/16
 * @Time : 12:56
 * @Description :
 */
public interface GirlDao extends JpaRepository<Girl,Integer>{

    //通过年龄来查询
    List<Girl> findByAge(Integer age);

}

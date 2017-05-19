package com.imoc.service;

import com.imoc.dao.GirlDao;
import com.imoc.entity.Girl;
import com.imoc.enums.ResultError;
import com.imoc.exception.UniteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/16
 * @Time : 13:02
 * @Description :
 */
@Service
public class GirlService {

    @Autowired
    private GirlDao girlDao;

    public List<Girl> getGirlList(){
        return girlDao.findAll();
    }

    public Girl saveGirl(Girl girl){
        return girlDao.save(girl);
    }

    public Girl findById(Integer id){
        return girlDao.findOne(id);
    }

    public void deleteById(Integer id){
        girlDao.delete(id);
    }

    public List<Girl> findByAge(Integer age){
        return girlDao.findByAge(age);
    }


    public void getAge(Integer id) throws Exception{
        Girl girl = girlDao.findOne(id);
        Integer age = girl.getAge();
        if(10 > age){
            throw new UniteException(ResultError.PRIMARY_SCHOOL);
        }else if(10 < age && 16 > age){
            throw new UniteException(ResultError.MIDDLE_SCHOOL);
        }
    }

}

package com.imoc.web;


import com.imoc.entity.Girl;
import com.imoc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Jason
 * @Date : 2017/5/16
 * @Time : 12:54
 * @Description :
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表（所有）
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlService.getGirlList();
    }

    /**
     * 添加一个女生
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("age") Integer age,
                          @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlService.saveGirl(girl);
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlService.findById(id);
    }

    /**
     * 根据年龄查询女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age") Integer age){
        return girlService.findByAge(age);
    }

    /**
     * 更新一个女生
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateById(@PathVariable("id") Integer id,@RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlService.saveGirl(girl);
    }

    /**
     * 删除一个女生
     */
    @DeleteMapping(value = "/girls/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        girlService.deleteById(id);
        return "delete success";
    }

}

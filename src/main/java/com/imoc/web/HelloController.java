package com.imoc.web;

import com.imoc.entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by oo on 2017/5/14.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(){
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable Integer id){
        return "id:"+id;
    }

    @RequestMapping(value = "/{id}/find",method = RequestMethod.GET)
    public String findId(@PathVariable Integer id){
        return "id:"+id;
    }

//    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @GetMapping("/find")
    public String findId2(@RequestParam(value="id",required = false,defaultValue = "0") Integer id){
        return "id:"+id;
    }

}

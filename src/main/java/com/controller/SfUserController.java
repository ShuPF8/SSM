package com.controller;


import com.alibaba.fastjson.JSON;
import com.entity.SfUser;
import com.service.ISfUserService;
import com.utils.BaseUtils;
import com.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2017-07-06
 */
@Controller
@RequestMapping("/sfUser")
public class SfUserController extends BaseUtils{

    @Autowired private ISfUserService iSfUserService;

    @RequestMapping("/save")
    public void save(){
        SfUser s = new SfUser();
        s.setSex("N");
        s.setAge(212);
        s.setPwd("777777");;
        s.setPhone("561565646556");
        s.setName("asd");
        ResultJson result = iSfUserService.save(s);
        backClient(JSON.toJSONString(result));
    }

}

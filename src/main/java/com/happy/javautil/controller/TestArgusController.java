package com.happy.javautil.controller;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.annotation.PID;
import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.entity.vo.RespVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试参数解析器
 **/
@Api("参数解析器测试")
@RequestMapping(value = "/argus")
@RestController
public class TestArgusController {
    
    /**
     * get路由带参数
     **/
    @GetMapping(value = "/{id}/{name}")
    public RespVo test1(@PID("id") Long id, @PID("name") String name) {
        System.out.println("入参:" + id + " name=" + name);
        return new RespVo();
    }
    
    @PostMapping(value = "/postTest")
    @ApiByToken(name = "baseId")
    public RespVo test2(@RequestBody TestEntity vo) {
        System.out.println(JSON.toJSONString(vo));
        return new RespVo();
    }
}

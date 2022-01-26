package com.happy.javautil.controller;

import com.alibaba.fastjson.JSON;
import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.entity.ValidEntity;
import com.happy.javautil.intercept.MyException;
import com.happy.javautil.service.TestService;
import com.happy.javautil.utils.PropertyUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(value = "test http")
@RestController
public class TestController {

    @Autowired
    private TestService summaryService;

    @Autowired
    private PropertyUtil propertyUtil;


    @ApiByToken(value = "菜鸟", isCheck = true)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, Object> test(
            @RequestParam("name") String name,
            HttpServletResponse response
    ) {
        if (1 == 1)
            throw new MyException("1212","111");
        summaryService.test();
        return null;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public void test1(
            @Validated @RequestBody TestEntity testEntity,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(JSON.toJSONString(propertyUtil.getContentExtract()));
        summaryService.test();
    }

    @ApiByToken(value = "无情铁手", isCheck = true)
    @RequestMapping(value = "/validTest", method = RequestMethod.POST)
    public void test(
            @Validated @RequestBody ValidEntity validEntity
    ) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }
}

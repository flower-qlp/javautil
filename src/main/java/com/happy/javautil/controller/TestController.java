package com.happy.javautil.controller;

import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(value = "test http")
@RestController
public class TestController {

    @Autowired
    private TestService summaryService;


    @ApiByToken(value = "菜鸟", isCheck = true)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(
            @RequestParam("name") String name,
            HttpServletResponse response
    ) {
        summaryService.test();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public void test1(
            @Validated @RequestBody TestEntity testEntity,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        summaryService.test();
    }
}

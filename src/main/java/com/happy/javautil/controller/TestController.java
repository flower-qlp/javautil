package com.happy.javautil.controller;

import com.happy.javautil.annotation.ApiByToken;
import com.happy.javautil.annotation.ExternalInterface;
import com.happy.javautil.entity.TestEntity;
import com.happy.javautil.entity.ValidEntity;
import com.happy.javautil.service.TestService;
import com.happy.javautil.utils.PropertyUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@Api(value = "test http")
@RestController
public class TestController {

    @Autowired
    private TestService summaryService;

    @Autowired
    private PropertyUtil propertyUtil;

    public Integer num = 0;
    ThreadLocal<String> numLocal = new ThreadLocal<>();


    @ApiByToken(value = "菜鸟", isCheck = true)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, Object> test(
            @RequestParam("name") String name,
            HttpServletResponse response
    ) {
        System.out.println("---------------->" + numLocal.get());
        UUID uuid = UUID.randomUUID();
        System.out.println("---------------->" + uuid.toString());
        numLocal.set(uuid.toString());
        System.out.println("---------------->" + numLocal.get());

        num += 1;
        System.out.println("---------------->" + num);
        //            throw new MyException("1212", "111");
        summaryService.test();
        return null;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public void test1(
            @Validated @RequestBody TestEntity testEntity,
            BindingResult bindingResult
    ) {
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//        }
//        System.out.println(JSON.toJSONString(propertyUtil.getContentExtract()));
        summaryService.test();
    }

    @ApiByToken(value = "无情铁手", isCheck = true)
    @RequestMapping(value = "/validTest", method = RequestMethod.POST)
    public void test(
            @Validated @RequestBody ValidEntity validEntity
    ) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }

    @RequestMapping(value = "/showLog", method = RequestMethod.GET)
    @ExternalInterface
    public TestEntity showLog(
    ) {
        TestEntity testEntity=new TestEntity();
        testEntity.setTheState("0.2");
        return testEntity;
    }
}

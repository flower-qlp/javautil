package com.happy.javautil.controller;

import com.happy.javautil.annotation.ID;
import com.happy.javautil.entity.vo.RespVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**测试参数解析器**/
@Api("参数解析器测试")
@RequestMapping(value = "/argus")
@RestController
public class TestArgusController {

    /**
     * get路由带参数
     * **/
    @GetMapping(value = "/{id}")
      public RespVo test1(@PathVariable("id") @ID Long id){
        System.out.println("入参:"+id);
        return new RespVo();
      }


}

package com.yuki.experiment.framework.controller;

import com.yuki.experiment.common.result.CommonResult;
import com.yuki.experiment.common.utils.JwtUtil;
import com.yuki.experiment.framework.entity.Administrator;
import com.yuki.experiment.framework.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("测试模块")
@RequestMapping("/test")
public class TestController {
    private final TestService service;
    @Autowired
    public TestController(TestService service){
        this.service=service;
    }
    @ApiOperation("这是一个测试controller")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public CommonResult<List<Administrator>> demo(){
        //wrapper.select("name","create_time").ge("id",1951121);
        return CommonResult.success(service.selectList());
    }

    @ApiOperation("插入测试")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public CommonResult<Integer> insert(@RequestBody Administrator administrator) {
        return CommonResult.success(service.insert(administrator));
    }

    @ApiOperation("删除测试")
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public CommonResult<Integer>delete(@RequestParam("name") String name) {
        return CommonResult.success(service.delete(name));
    }

    @ApiOperation("更新测试")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public CommonResult<Integer> update(@RequestBody Administrator administrator) {
        return CommonResult.success(service.update(administrator));
    }

    @ApiOperation("这是一个测试controller")
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public CommonResult<String> demo1(){
        System.out.println(JwtUtil.getKEY());
        return CommonResult.success("2333");
    }


}
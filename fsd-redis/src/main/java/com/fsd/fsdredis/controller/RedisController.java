package com.fsd.fsdredis.controller;

import com.fsd.fsdredis.entity.BaseObject;
import com.fsd.fsdredis.entity.User;
import com.fsd.fsdredis.entity.base.Response;
import com.fsd.fsdredis.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by lilei
 * since 2019/7/6
 **/
@RestController
@RequestMapping("/redis")
@Api("redis测试接口")
public class RedisController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ApiOperation(value = "设置参数到redis中", notes = "设置参数", response = BaseObject.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "BaseObject"),
            @ApiImplicitParam(name = "value", value = "value", required = true, dataType = "string", paramType = "BaseObject")})
    public BaseObject setValue(@RequestBody BaseObject baseObject) {
        redisUtil.set(baseObject.getKey(), baseObject.getVlaue());
        return baseObject;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(value = "根据key获取参数", notes = "获取参数", response = String.class)
    @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "BaseObject")
    public String getValue(@RequestBody BaseObject baseObject) {
        return redisUtil.get(baseObject.getKey());

    }

    @RequestMapping(value = "/swagger", method = RequestMethod.POST)
    @ApiOperation(value = "根据key获取参数", notes = "获取参数")
    public Response<User> getSwagger(@RequestBody Response<User> response) {

        return null;
    }

    @RequestMapping(value = "/swagger1", method = RequestMethod.POST)
    @ApiOperation(value = "根据key获取参数", notes = "获取参数")
    public Response<List<User>> getSwagger1(@RequestBody Response<User> response) {

        return null;
    }


}

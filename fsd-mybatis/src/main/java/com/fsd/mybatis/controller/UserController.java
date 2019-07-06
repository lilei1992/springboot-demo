package com.fsd.mybatis.controller;

import com.fsd.mybatis.entity.User;
import com.fsd.mybatis.entity.base.Response;
import com.fsd.mybatis.service.UserService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Api(tags="用户相关接口",value = "该参数没什么意义，所以不需要配置")
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation(value="获取用户详细信息", notes="获取所用用户信息")
    public Response<List<User>> getUser(User user){
        Page<User> page = userService.queryUser(user.getPage(),user.getPageSize());
        Response<List<User>> response  =  new Response<>();
        response.setData(page);
      return response;
    }
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
        public ResponseEntity<User> getUserById (@PathVariable(value = "id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}

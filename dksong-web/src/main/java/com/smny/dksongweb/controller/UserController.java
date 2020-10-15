package com.smny.dksongweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smny.dksongweb.entity.User;
import com.smny.dksongweb.mapper.UserMapper;
import com.smny.dksongweb.utils.JsonRet;
import com.smny.dksongweb.vo.UserAddVO;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YuanJing
 * @since 2020-09-03
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户信息",value = "用户信息")

public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(notes = "用户列表", value = "用户列表")
    @PostMapping(value = "/get/list/{pageNumber}/{pageSize}", produces = {"application/json;charset=UTF-8"})


    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class)
    })
    public JsonRet getSalesIdCardList(@PathVariable("pageNumber")Integer pageNumber,@PathVariable("pageSize")Integer pageSize,
                                      @RequestBody UserAddVO uservo) {
        User user = new User();
        BeanUtils.copyProperties(uservo,user);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        Page<User> objectPage = new Page<>(pageNumber, pageSize);
        IPage<User> userIPage = userMapper.selectByRoleId(objectPage, user);
        IPage<User> users = userMapper.selectPage(objectPage, userQueryWrapper);
        System.out.println(users.getTotal());
        System.out.println(users.getSize());
        System.out.println(users.getCurrent());
        System.out.println(users.getPages());

        return JsonRet.buildSuccRet(users);
    }

    @ApiOperation(notes = "新增用户", value = "新增用户")
    @PostMapping(value = "/post/info", produces = {"application/json;charset=UTF-8"})


    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class)
    })
    public JsonRet insertUser(@Validated @RequestBody UserAddVO userAddVO) {

        User user = new User();
        BeanUtils.copyProperties(userAddVO, user);
        userMapper.insert(user);
        return JsonRet.buildSuccRet();
    }

    @ApiOperation(notes = "修改用户信息", value = "修改用户信息")
    @PostMapping(value = "/put/info", produces = {"application/json;charset=UTF-8"})


    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class)
    })
    public JsonRet updateUser() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123");
        user.setUserType(1);

        userMapper.updateById(user);

        userMapper.update(user, new UpdateWrapper<User>());
        return JsonRet.buildSuccRet();
    }

    @ApiOperation(notes = "MPsort排序", value = "MPsort排序")
    @PostMapping(value = "/sort/info", produces = {"application/json;charset=UTF-8"})


    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class)
    })
    public JsonRet sortUser() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123");
        user.setUserType(1);

        userMapper.updateById(user);

        userMapper.update(user, new UpdateWrapper<User>());
        return JsonRet.buildSuccRet();
    }
}


package com.mtp.bar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mtp.bar.entity.User;
import com.mtp.bar.enums.UserEnum;
import com.mtp.bar.exception.BombException;
import com.mtp.bar.mapper.UserMapper;
import com.mtp.bar.utils.JsonRet;
import com.mtp.bar.utils.MD5Util;
import com.mtp.bar.utils.UUIDUtil;
import com.mtp.bar.vo.ParamVO;
import com.mtp.bar.vo.UserLoginVO;
import com.mtp.bar.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 贴吧用户表 前端控制器
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户信息", value = "用户信息")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(notes = "用户登陆", value = "用户登陆")
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet getLoginCode(@Valid @RequestBody UserLoginVO userLoginVO) {
        System.out.println(userLoginVO);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        User user = new User();
        user.setUserNumber(userLoginVO.getUserNumber());
        userQueryWrapper.eq("user_number",user.getUserNumber());
        User resultUser = userMapper.selectOne(userQueryWrapper);
        System.out.println("resultUser=={}"+resultUser);
        if (Objects.nonNull(resultUser)) {
            //对比密码是否正确
            if (!resultUser.getUserPassword().equals(MD5Util.md5(userLoginVO.getUserPassword()))) {
                throw new BombException(UserEnum.USER_PASSWORD_ERROE);
            }

            if (null != resultUser.getUserToken()) {
                return JsonRet.buildSuccRet(resultUser);
            }
            //得到token
            String token = UUIDUtil.getOrderNumberInfo();
            //封装token
            String finalToken = resultUser.getUserId() + "_" + token;

            //设置token
            resultUser.setUserToken(finalToken);

            userMapper.updateById(resultUser);
        } else {
            throw new BombException(UserEnum.USER_NOT_EXIST);
        }


        return JsonRet.buildSuccRet(resultUser);
    }


    @ApiOperation(notes = "用户注册", value = "用户注册")
    @PostMapping(value = "/regist", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet getRegist(@Valid @RequestBody UserVO userLoginVO) {
        System.out.println("注册参数"+userLoginVO);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        User user = new User();
        userQueryWrapper.eq("user_number",user.getUserNumber());
        //用户是否存在
        User userNumbers = userMapper.selectOne(userQueryWrapper);
        System.out.println("用户已存在"+userNumbers);
        if (Objects.nonNull(userNumbers)) {

            throw new BombException(UserEnum.USER_IS_EXIST);
        }

        user.setUserPassword(MD5Util.md5(userLoginVO.getUserPassword()));
        user.setUserNumber(userLoginVO.getUserNumber());

        //得到token
        String token = UUIDUtil.getOrderNumberInfo();
        //封装token

        userMapper.insert(user);
        String finalToken = user.getUserId() + "_" + token;

        //设置token
        user.setUserToken(finalToken);

        userMapper.updateById(user);
        System.out.println("user=={}"+user);
        return JsonRet.buildSuccRet(user);
    }

    @ApiOperation(notes = "退出登陆", value = "退出登陆")
    @PostMapping(value = "/logout", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet logout(@Valid @RequestBody ParamVO paramVO) {

        //用户是否存在
        User userNumbers = userMapper.selectById(paramVO.getParamsId());


        return JsonRet.buildSuccRet();
    }

}


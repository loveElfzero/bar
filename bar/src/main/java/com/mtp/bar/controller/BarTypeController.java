package com.mtp.bar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mtp.bar.entity.BarType;
import com.mtp.bar.entity.User;
import com.mtp.bar.enums.UserEnum;
import com.mtp.bar.exception.BombException;
import com.mtp.bar.mapper.BarTypeMapper;
import com.mtp.bar.mapper.UserMapper;
import com.mtp.bar.utils.JsonRet;
import com.mtp.bar.utils.MD5Util;
import com.mtp.bar.utils.UUIDUtil;
import com.mtp.bar.vo.BarTypeVO;
import com.mtp.bar.vo.UserLoginVO;
import com.mtp.bar.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 贴吧分类表 前端控制器
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@RestController
@RequestMapping("/bartype")
@Api(tags = "分类信息", value = "分类信息")
public class BarTypeController {

    @Autowired
    private BarTypeMapper barTypeMapper;

    @ApiOperation(notes = "添加分类", value = "添加分类")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet addType(@Valid @RequestBody BarTypeVO userLoginVO) {




        BarType barType = new BarType();
        barType.setTypeName(userLoginVO.getTypeName());
        QueryWrapper<BarType> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.eq("type_name",userLoginVO.getTypeName());
        BarType resultType = barTypeMapper.selectOne(userQueryWrapper);
        if (Objects.nonNull(resultType)) {

                throw new BombException(201,"分类名称已存在");

        }

        barTypeMapper.insert(barType);

        return JsonRet.buildSuccRet();
    }


    @ApiOperation(notes = "分类列表", value = "分类列表")
    @PostMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功",response =BarType.class )
    })
    public JsonRet getTypeList() {
        QueryWrapper<BarType> userQueryWrapper = new QueryWrapper<>();
        List<BarType> barTypes = barTypeMapper.selectList(userQueryWrapper);
        return JsonRet.buildSuccRet(barTypes);
    }

}


package com.mtp.bar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mtp.bar.entity.Bar;
import com.mtp.bar.entity.BarComment;
import com.mtp.bar.entity.BarType;
import com.mtp.bar.entity.User;
import com.mtp.bar.exception.BombException;
import com.mtp.bar.mapper.BarCommentMapper;
import com.mtp.bar.mapper.BarMapper;
import com.mtp.bar.mapper.BarTypeMapper;
import com.mtp.bar.mapper.UserMapper;
import com.mtp.bar.utils.JsonRet;
import com.mtp.bar.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@RestController
@RequestMapping("/bar")
@Api(tags = "帖子信息", value = "帖子信息")
public class BarController {
    @Autowired
    private BarCommentMapper barCommentMapper;
    @Autowired
    private BarMapper barMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BarTypeMapper barTypeMapper;

    @ApiOperation(notes = "添加帖子", value = "添加帖子")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 403, message = "请重新登陆")
    })
    public JsonRet addBar(@Valid @RequestBody BarAddVO barAddVO) {


        Bar bar = new Bar();
        BeanUtils.copyProperties(barAddVO, bar);
        User user = userMapper.selectById(barAddVO.getBarUserId());
        bar.setBarUserNumber(user.getUserNumber());
        BarType barType = barTypeMapper.selectById(barAddVO.getBarTypeId());
        bar.setBarTypeName(barType.getTypeName());
        barMapper.insert(bar);

        return JsonRet.buildSuccRet();
    }


    @ApiOperation(notes = "删除帖子", value = "删除帖子")
    @PostMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet delBar(@Valid @RequestBody BarDelVO barDelVO) {


        Bar resultBar = barMapper.selectById(barDelVO.getBarId());
        if (!resultBar.getBarUserId().equals(barDelVO.getBarUserId())) {
            System.out.println("用户无权限删除该帖子{}" + barDelVO);
            throw new BombException(201, "用户无权限删除该帖子");
        }
        barMapper.deleteById(barDelVO.getBarId());

        return JsonRet.buildSuccRet();
    }


    @ApiOperation(notes = "主页帖子列表", value = "主页帖子列表")
    @PostMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = Bar.class)
    })
    public JsonRet barList(@Valid @RequestBody PageParamsVO paramVO) {


        QueryWrapper<Bar> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("bar_user_id", paramVO.getParamsId());
        Page<Bar> objectPage = new Page<>(paramVO.getPageNumber(), paramVO.getPageSize());

        IPage<Bar> barIPage = barMapper.selectPage(objectPage, userQueryWrapper);


        return JsonRet.buildSuccRet(barIPage);
    }


    @ApiOperation(notes = "所有帖子列表", value = "所有帖子列表")
    @PostMapping(value = "/all/list", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = Bar.class)
    })
    public JsonRet getAllBar(@Valid @RequestBody PageParamsVO paramVO) {


        Bar bar = new Bar();
        QueryWrapper<Bar> userQueryWrapper = new QueryWrapper<>();
        if (null != paramVO.getParamsId()) {
            userQueryWrapper.eq("bar_type_id", paramVO.getParamsId());
        }

        Page<Bar> objectPage = new Page<>(paramVO.getPageNumber(), paramVO.getPageSize());

        IPage<Bar> barIPage = barMapper.selectPage(objectPage, userQueryWrapper);
        List<Bar> records = barIPage.getRecords();
        System.out.println("records=={}" + records);
        if (records.size() > 0) {
            for (Bar bar1 : records) {
                QueryWrapper<BarComment> commentQueryWrapper = new QueryWrapper<>();
                commentQueryWrapper.eq("bar_id", bar1.getBarId());
                Page<BarComment> commentPage = new Page<>(1, paramVO.getPageSize());
                //查询评论列表
                IPage<BarComment> barCommentIPage = barCommentMapper.selectPage(commentPage, commentQueryWrapper);
                bar1.setBarComments(barCommentIPage.getRecords());
            }
        }

        return JsonRet.buildSuccRet(barIPage);
    }


}


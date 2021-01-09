package com.mtp.bar.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mtp.bar.entity.Bar;
import com.mtp.bar.entity.BarComment;
import com.mtp.bar.entity.BarType;
import com.mtp.bar.exception.BombException;
import com.mtp.bar.mapper.BarCommentMapper;
import com.mtp.bar.mapper.BarMapper;
import com.mtp.bar.mapper.BarTypeMapper;
import com.mtp.bar.utils.JsonRet;
import com.mtp.bar.vo.BarCommentReplyVO;
import com.mtp.bar.vo.BarCommentVO;
import com.mtp.bar.vo.BarTypeVO;
import com.mtp.bar.vo.PageParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
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
 * 贴吧评论表 前端控制器
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@RestController
@RequestMapping("/barComment")
@Api(tags = "用户评论", value = "用户评论")
public class BarCommentController {
    @Autowired
    private BarCommentMapper barCommentMapper;
    @Autowired
    private BarMapper barMapper;

    @ApiOperation(notes = "添加评论", value = "添加评论")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet addComment(@Valid @RequestBody BarCommentVO barCommentVO) {


        BarComment barComment = new BarComment();
        BeanUtils.copyProperties(barCommentVO, barComment);
        Bar bar = barMapper.selectById(barCommentVO.getBarId());
        barComment.setBarUserId(bar.getBarUserId());
        barComment.setBarUserNumber(bar.getBarUserNumber());
        barCommentMapper.insert(barComment);

        return JsonRet.buildSuccRet();
    }

    @ApiOperation(notes = "回复评论", value = "回复评论")
    @PostMapping(value = "/reply", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "用户不存在"),
            @ApiResponse(code = 0, message = "code未知，阿里短信发送失败返回的信息")
    })
    public JsonRet reolyComment(@Valid @RequestBody BarCommentReplyVO barCommentVO) {


        BarComment barComment = new BarComment();

        BeanUtils.copyProperties(barCommentVO, barComment);

        BarComment returnComment = barCommentMapper.selectById(barCommentVO.getBarCommentId());
        if(!returnComment.getBarUserId().equals(barCommentVO.getBarUserId())){
            System.out.println("用户无权限回复该评论");
            throw new BombException(201, "用户无权限回复该评论");
        }
        if (returnComment.getBarReplyStatus()) {
            System.out.println("已经回复过该用户");
            throw new BombException(201, "已经回复过该用户");
        }
        returnComment.setBarReplyStatus(true);
        returnComment.setBarReplyContent(barCommentVO.getBarReplyContent());
        barCommentMapper.updateById(barComment);

        return JsonRet.buildSuccRet();
    }


    @ApiOperation(notes = "评论列表", value = "评论列表")
    @PostMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功",response =BarComment.class )
    })
    public JsonRet getCommentList(@RequestBody  PageParamsVO paramsVO) {
        QueryWrapper<BarComment> userQueryWrapper = new QueryWrapper<>();
        BarComment barComment = new BarComment();
        barComment.setBarId(paramsVO.getParamsId());
        userQueryWrapper.setEntity(barComment);
        Page<BarComment> objectPage = new Page<>(paramsVO.getPageNumber(), paramsVO.getPageSize());

        IPage<BarComment> users = barCommentMapper.selectPage(objectPage, userQueryWrapper);
        return JsonRet.buildSuccRet(users);
    }
}


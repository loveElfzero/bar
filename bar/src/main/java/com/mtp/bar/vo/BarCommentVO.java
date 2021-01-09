package com.mtp.bar.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 贴吧评论表
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BarCommentVO", description="添加评论")
public class BarCommentVO  {



    @ApiModelProperty(value = "帖子id")
    private Integer barId;
    @ApiModelProperty(value = "评论内容")
    private String barCommentContent;

    @ApiModelProperty(value = "评论用户id")
    private Integer barCommentUserId;

    @ApiModelProperty(value = "评论用户账号")
    private String barCommentUserNumber;







}

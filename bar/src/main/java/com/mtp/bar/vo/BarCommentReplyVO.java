package com.mtp.bar.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
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
@ApiModel(value = "BarCommentVO", description = "添加评论")
public class BarCommentReplyVO {

    @ApiModelProperty(value = "评论id")
    private Integer barCommentId;
    @NotBlank(message = "请输入回复内容")
    @ApiModelProperty(value = "回复内容")
    private String barReplyContent;

    @ApiModelProperty(value = "用户id")
    private Integer barUserId;


}

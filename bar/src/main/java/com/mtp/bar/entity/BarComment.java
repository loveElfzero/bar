package com.mtp.bar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="BarComment对象", description="贴吧评论表")
public class BarComment extends Model<BarComment> {


    @ApiModelProperty(value = "评论id")
    @TableId(value = "bar_comment_id", type = IdType.AUTO)
    private Integer barCommentId;

    @ApiModelProperty(value = "评论内容")
    private String barCommentContent;

    @ApiModelProperty(value = "回复内容")
    private String barReplyContent;

    @ApiModelProperty(value = "用户id")
    private Integer barUserId;

    @ApiModelProperty(value = "用户账号")
    private String barUserNumber;

    @ApiModelProperty(value = "评论用户id")
    private Integer barCommentUserId;

    @ApiModelProperty(value = "评论用户账号")
    private String barCommentUserNumber;

    @ApiModelProperty(value = "帖子id")
    private Integer barId;

    @ApiModelProperty(value = "回复状态")
    private Boolean barReplyStatus;


    @Override
    protected Serializable pkVal() {
        return this.barCommentId;
    }

}

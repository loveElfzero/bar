package com.mtp.bar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Bar对象", description="")
public class Bar extends Model<Bar> {


    @ApiModelProperty(value = "发帖id")
    @TableId(value = "bar_id", type = IdType.AUTO)
    private Integer barId;

    @ApiModelProperty(value = "发帖标题")
    private String barName;

    @ApiModelProperty(value = "发帖内容")
    private String barContent;

    @ApiModelProperty(value = "发帖分类id")
    private Integer barTypeId;

    @ApiModelProperty(value = "发帖分类名称")
    private String barTypeName;

    @ApiModelProperty(value = "用户id")
    private Integer barUserId;

    @ApiModelProperty(value = "用户账号")
    private String barUserNumber;

    @ApiModelProperty(value = "贴吧状态 1：审核中 2：已通过  3：未通过")
    private Integer barStatus;

    @ApiModelProperty(value = "贴子类型 1:普通贴 2：精华帖")
    private Integer barType;
    @ApiModelProperty(value = "评论列表")
    @TableField(exist = false)
    private List<BarComment> barComments;

    @Override
    protected Serializable pkVal() {
        return this.barId;
    }

}

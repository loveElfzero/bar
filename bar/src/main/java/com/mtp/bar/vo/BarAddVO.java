package com.mtp.bar.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
@ApiModel(value = "BarAddVO", description = "添加贴吧")
public class BarAddVO {


    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "发帖标题")
    private String barName;
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "发帖内容")
    private String barContent;
    @NotNull(message = "请选择分类")
    @ApiModelProperty(value = "发帖分类id")
    private Integer barTypeId;

    @NotNull(message = "请先登录")
    @ApiModelProperty(value = "用户id")
    private Integer barUserId;


}

package com.mtp.bar.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel(value = "BarDelVO", description = "删除帖子")
public class BarDelVO {


    @NotNull(message = "参数异常")
    @ApiModelProperty(value = "帖子id")
    private Integer barId;

    @NotNull(message = "请先登录")
    @ApiModelProperty(value = "用户id")
    private Integer barUserId;


}

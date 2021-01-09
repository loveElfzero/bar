package com.mtp.bar.vo;

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
@ApiModel(value="PageParamsVO", description="分页参数")
public class PageParamsVO {



    @ApiModelProperty(value = "参数id")
    private Integer paramsId;
    @ApiModelProperty(value = "分页数量")
    private Integer pageNumber=1;

    @ApiModelProperty(value = "分页条数")
    private Integer pageSize=10;








}

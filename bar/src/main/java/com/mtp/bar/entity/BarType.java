package com.mtp.bar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 贴吧分类表
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BarType对象", description="贴吧分类表")
public class BarType extends Model<BarType> {


    @ApiModelProperty(value = "分类id")
    @TableId(type = IdType.AUTO)
    private Integer typeId;

    @ApiModelProperty(value = "分类名称")
    private String typeName;

    @ApiModelProperty(value = "创建时间")
    private Date typeCreateTime;


    @Override
    protected Serializable pkVal() {
        return this.typeId;
    }

}

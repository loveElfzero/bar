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
 * 贴吧用户表
 * </p>
 *
 * @author YuanJing
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="贴吧用户表")
public class User extends Model<User> {


    @ApiModelProperty(value = "用户id")
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户号码")
    private String userNumber;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;
    @ApiModelProperty(value = "用户token")
    private String userToken;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "创建时间")
    private String userCreateTime;

    @ApiModelProperty(value = "修改时间")
    private String userUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}

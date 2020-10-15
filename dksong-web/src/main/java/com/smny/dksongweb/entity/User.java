package com.smny.dksongweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;
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
 * @since 2020-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bomb_user")
@ApiModel(value = "User对象", description = "")
public class User extends Model<User> {


    private Integer userId;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "用户账号")
    private String userPhone;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "登陆时间")
    private String userLoginTime;

    @ApiModelProperty(value = "创建时间")
    private String userCreateTime;

    @ApiModelProperty(value = "修改时间")
    private String userUpdateTime;

    @ApiModelProperty(value = "token")
    private String userToken;

    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;
    @TableField(exist = false)
    private List<RoleUser> roleUsers;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}

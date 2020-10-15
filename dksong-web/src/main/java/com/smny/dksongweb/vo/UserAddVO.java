package com.smny.dksongweb.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="UserAddVO", description="新增用户参数")
public class UserAddVO implements Serializable {


    private Integer userId;

    @NotBlank(message = "userName不能为空")
    @ApiModelProperty(value = "用户昵称")
    private String userName;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    @NotNull(message = "用户账号不能为空")
    @ApiModelProperty(value = "用户账号")
    private String userPhone;
    @NotNull(message = "用户密码不能为空")
    @ApiModelProperty(value = "用户密码")
    private String userPassword;


    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;


}

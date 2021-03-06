package com.mtp.bar.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "UserVO", description = "用户注册")
public class UserVO {



    @NotBlank(message = "用户账号不能为空")
    @ApiModelProperty(value = "用户账号")
    @Length(max = 12,message = "用户账号长度应在6-12位之间",min = 6)
    private String userNumber;
    @NotBlank(message = "用户密码不能为空")
    @ApiModelProperty(value = "用户密码")
    private String userPassword;




}

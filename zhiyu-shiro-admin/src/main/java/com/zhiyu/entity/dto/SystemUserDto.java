package com.zhiyu.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wengzhiyu
 * @date 2020/5/18
 */
@Data
public class SystemUserDto implements Serializable {
    private static final long serialVersionUID = 2970188542115932902L;

    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    private String account;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("头像图片")
    private String headImg;

    @ApiModelProperty("性别 1:男，2:女，3:未知")
    private Integer sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

}

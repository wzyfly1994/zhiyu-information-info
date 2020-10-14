package com.zhiyu.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/9/15
 */
@Data
public class SystemRoleDto implements Serializable {
    private static final long serialVersionUID = -515591619334343783L;

    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(value = "角色名", required = true)
    private String roleName;

    @NotEmpty(message = "菜单列表不能为空")
    @ApiModelProperty(value = "菜单列表", required = true)
    private List<Long> menuIdList;

    @NotEmpty(message = "部门不能为空")
    @ApiModelProperty(value = "部门", required = true)
    private Long depId;

    @NotEmpty(message = "是否可用不能为空")
    @ApiModelProperty(value = "是否可用", required = true)
    private boolean isUse;

    private Date recordDate;
}

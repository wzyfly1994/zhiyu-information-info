package com.zhiyu.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wengzhiyu
 * @date 2020/01/09
 */
@Data
@Table(name = "system_permission")
@Entity
public class SystemPermission implements Serializable {

    private static final long serialVersionUID = 1286088385795878538L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(16) comment '权限名称'")
    private String permissionName;


    @Column(columnDefinition = "varchar(64) comment '权限值'")
    private String permissionValue;

    @Column(columnDefinition = "varchar(64) comment '菜单Id'")
    private String menuId;


    @Column(columnDefinition = "varchar(64) comment '权限描述'")
    private String description;

    @Column(columnDefinition = " timestamp comment '记录时间'")
    private Date recordDate;

}

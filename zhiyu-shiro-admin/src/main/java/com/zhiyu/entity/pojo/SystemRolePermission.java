package com.zhiyu.entity.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Data
@Table(name = "system_role_permission")
@Entity
@DynamicUpdate
@DynamicInsert
public class SystemRolePermission  implements Serializable {

    private static final long serialVersionUID = -7756080639525873726L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = " bigint(20) comment '角色id'")
    private Long roleId;

    @Column(columnDefinition = " bigint(20) comment '权限id'")
    private Long permissionId;
}

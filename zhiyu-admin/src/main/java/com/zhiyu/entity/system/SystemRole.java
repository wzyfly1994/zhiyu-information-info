package com.zhiyu.entity.system;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wengzhiyu
 * @date 2020/01/08
 */
@Data
@Table(name = "system_role")
@Entity
@DynamicUpdate
@DynamicInsert
public class SystemRole implements Serializable {

    private static final long serialVersionUID = 8138231999166051122L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "varchar(16) comment '角色名'")
    private String roleName;


    @Column(columnDefinition = "varchar(64) comment '角色值'")
    private String roleValue;


    @Column(columnDefinition = "tinyint(1) comment'是否有效'")
    private boolean isUse;

    @Column(columnDefinition = " timestamp comment '记录时间'")
    private Date recordDate;


}

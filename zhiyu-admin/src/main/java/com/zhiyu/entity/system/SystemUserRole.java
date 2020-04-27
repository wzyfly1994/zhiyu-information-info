package com.zhiyu.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wengzhiyu
 * @date 2020/01/08
 */
@Data
@Entity
@Table(name = "system_user_role")
public class SystemUserRole implements Serializable {

    private static final long serialVersionUID = -2492563990586576637L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long roleId;
}

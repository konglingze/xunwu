package edu.nuc.xunwupro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName Role
 * @Description 用户角色
 * @Author 孔先生
 * @Date 2018/10/30 13:02
 * @Version 1.0
 **/
@Table(name = "role")
@Entity
public class Role {
    private Long id;
    //用户id
    @Column(name = "user_id")
    private Long userId;
    //权限名
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

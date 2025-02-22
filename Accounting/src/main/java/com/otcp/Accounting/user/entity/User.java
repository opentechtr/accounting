package com.otcp.Accounting.user.entity;

import com.otcp.Accounting.common.baseEntity.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class User extends BaseEntity {
    private String username;
}

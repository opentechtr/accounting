package com.otcp.Accounting.user.entity;

import com.otcp.Accounting.common.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class User extends BaseEntity {
    private String username;
}

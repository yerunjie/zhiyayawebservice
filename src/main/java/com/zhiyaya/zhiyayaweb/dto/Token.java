package com.zhiyaya.zhiyayaweb.dto;

import com.zhiyaya.zhiyayaweb.constants.Role;
import lombok.Data;

@Data
public class Token {

    public Token(Role role, int id, long expireTime) {
        this(role, id, expireTime, -1);
    }

    public Token(Role role, int id, long expireTime, int version) {
        this.role = role;
        this.expireTime = expireTime;
        this.id = id;
        this.version = version;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() >= expireTime;
    }

    private Role role;
    private long expireTime;
    private int id;
    private int version;

    @Override
    public String toString() {
        return role.toString() + "_" + id;
    }
}

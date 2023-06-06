package com.week_13.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class LoginInfo {
    @NotEmpty
    @NotBlank
    private String userid;
    @NotEmpty
    @NotBlank
    private String pwd;
    private Boolean rememberid;

    public String getUserid() {

        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getRememberid() {
        return rememberid;
    }

    public void setRememberid(Boolean rememberid) {
        this.rememberid = rememberid;
    }
}

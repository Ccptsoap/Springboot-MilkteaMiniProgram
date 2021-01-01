package com.demo01.demo.dto;

public class LoginInfoDTO {
    private String nickname;
    private String openid;

    public LoginInfoDTO() {}

    public LoginInfoDTO(String nickname, String openid) {
        this.nickname = nickname;
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}

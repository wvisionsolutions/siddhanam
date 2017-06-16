package com.ciber.momentum.entity;

import java.util.List;

import com.ciber.momentum.handler.UserResponse;

public class LoginResponse extends Response
{
    private List<UserResponse> userList;
    private String sessionId;
    private String role;;

    public List<UserResponse> getUserList()
    {
        return userList;
    }

    public void setUserList(List<UserResponse> userList)
    {
        this.userList = userList;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}

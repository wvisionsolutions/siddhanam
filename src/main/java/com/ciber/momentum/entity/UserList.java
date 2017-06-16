package com.ciber.momentum.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ciber.momentum.handler.UserResponse;

@XmlRootElement(name = "users")
public class UserList
{

    private List<UserResponse> data;

    @XmlElement(name = "user")
    public List<UserResponse> getData()
    {
        return data;
    }

    public void setData(List<UserResponse> data)
    {
        this.data = data;
    }
}

package com.ciber.momentum.handler;

import java.util.List;

public class UserPhone
{
    private int userId;
    private List<PhoneResponse> phoneResponse;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public List<PhoneResponse> getPhoneId()
    {
        return phoneResponse;
    }

    public void setPhoneId(List<PhoneResponse> phoneResponse)
    {
        this.phoneResponse = phoneResponse;
    }

}

package com.ciber.momentum.handler;

import java.io.Serializable;

public class PhoneTypeResponse implements Serializable
{
    private int phoneTypeId;
    private String description;

    public int getPhoneTypeId()
    {
        return phoneTypeId;
    }

    public void setPhoneTypeId(int phoneTypeId)
    {
        this.phoneTypeId = phoneTypeId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}

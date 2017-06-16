package com.ciber.momentum.handler;

import java.io.Serializable;

public class PhoneResponse implements Serializable
{
    private int phoneId;
    private String phoneNumber;
    private CountryResponse country;
    private int phoneType;

    public int getPhoneId()
    {
        return phoneId;
    }

    public void setPhoneId(int phoneId)
    {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public CountryResponse getCountry()
    {
        return country;
    }

    public void setCountry(CountryResponse country)
    {
        this.country = country;
    }

    public int getPhoneType()
    {
        return phoneType;
    }

    public void setPhoneType(int phoneType)
    {
        this.phoneType = phoneType;
    }
}

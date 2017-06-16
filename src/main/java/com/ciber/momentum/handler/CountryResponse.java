package com.ciber.momentum.handler;

import java.io.Serializable;

public class CountryResponse implements Serializable
{
    private int countryId;
    private char countryCode;
    private String description;

    public int getCountryId()
    {
        return countryId;
    }

    public void setCountryId(int countryId)
    {
        this.countryId = countryId;
    }

    public char getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(char countryCode)
    {
        this.countryCode = countryCode;
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

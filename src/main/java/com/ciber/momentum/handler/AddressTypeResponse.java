package com.ciber.momentum.handler;

import java.io.Serializable;

public class AddressTypeResponse implements Serializable
{
    private int addressTypeId;
    private String description;

    public int getAddressTypeId()
    {
        return addressTypeId;
    }

    public void setAddressTypeId(int addressTypeId)
    {
        this.addressTypeId = addressTypeId;
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

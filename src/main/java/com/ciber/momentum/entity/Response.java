package com.ciber.momentum.entity;

public class Response
{
    String responseCode = "";
    String responseMessage;
    Object responseData;

    public String getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(String responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getResponseMessage()
    {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage)
    {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData()
    {
        return responseData;
    }

    public void setResponseData(Object responseData)
    {
        this.responseData = responseData;
    }
    
    
}

package com.ciber.momentum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Phone()
    {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private int recordId;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "countryid")
    private int countryId;

    @Column(name = "phonetype")
    private int phoneType;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userPhoneSet")
    private List<User> userSet = new ArrayList<User>(0);

    /**
     * @return the userSet
     */
    public List<User> getUserSet()
    {
        return userSet;
    }

    /**
     * @param userSet the userSet to set
     */
    public void setUserSet(List<User> userSet)
    {
        this.userSet = userSet;
    }

    /**
     * @return the phoneType
     */
    public int getPhoneType()
    {
        return phoneType;
    }

    /**
     * @param phoneType the phoneType to set
     */
    public void setPhoneType(int phoneType)
    {
        this.phoneType = phoneType;
    }

    /**
     * @return the countryId
     */
    public int getCountryId()
    {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(int countryId)
    {
        this.countryId = countryId;
    }

//    @ManyToOne
//    @JoinColumn(name = "phonetype", insertable = true, updatable = false)
//    private PhoneType phType;
//
//    @ManyToOne
//    @JoinColumn(name = "countryid", insertable = true, updatable = false)
//    private Country country;

   /* *//**
     * @return the phType
     *//*
    public PhoneType getPhType()
    {
        return phType;
    }

    *//**
     * @param phType the phType to set
     *//*
    public void setPhType(PhoneType phType)
    {
        this.phType = phType;
    }*/

    /**
     * @return the recordId
     */
    public int getRecordId()
    {
        return recordId;
    }

    /**
     * @param recordId the recordId to set
     */
    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

  /*  *//**
     * @return the country
     *//*
    public Country getCountry()
    {
        return country;
    }

    *//**
     * @param country the country to set
     *//*
    public void setCountry(Country country)
    {
        this.country = country;
    }*/

}

package com.ciber.momentum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private int recordId;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state", columnDefinition = "char(2)")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "addresstype")
    private int addressType;

    /**
     * @return the addressType
     */
    public int getAddressType()
    {
        return addressType;
    }

    /**
     * @param addressType the addressType to set
     */
    public void setAddressType(int addressType)
    {
        this.addressType = addressType;
    }

    public Address()
    {
        super();
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userObject;

    @ManyToOne
    @JoinColumn(name = "addresstype", insertable = false, updatable = false)
    private AddressType adrsObject;

    /**
     * @return the adrsObject
     */
    public AddressType getAdrsObject()
    {
        return adrsObject;
    }

    /**
     * @param adrsObject the adrsObject to set
     */
    public void setAdrsObject(AddressType adrsObject)
    {
        this.adrsObject = adrsObject;
    }

    /**
     * @return the userObject
     */
    public User getUserObject()
    {
        return userObject;
    }

    /**
     * @param userObject the userObject to set
     */
    public void setUserObject(User userObject)
    {
        this.userObject = userObject;
    }

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
     * @return the line1
     */
    public String getLine1()
    {
        return line1;
    }

    /**
     * @param line1 the line1 to set
     */
    public void setLine1(String line1)
    {
        this.line1 = line1;
    }

    /**
     * @return the line2
     */
    public String getLine2()
    {
        return line2;
    }

    /**
     * @param line2 the line2 to set
     */
    public void setLine2(String line2)
    {
        this.line2 = line2;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip)
    {
        this.zip = zip;
    }

}

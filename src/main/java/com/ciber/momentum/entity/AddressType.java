package com.ciber.momentum.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "addresstype")
public class AddressType implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AddressType()
    {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private int recordId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "adrsObject", cascade = CascadeType.ALL)
    private Set<Address> addressSet;

    /**
     * @return the addressSet
     */
    public Set<Address> getAddressSet()
    {
        return addressSet;
    }

    /**
     * @param addressSet the addressSet to set
     */
    public void setAddressSet(Set<Address> addressSet)
    {
        this.addressSet = addressSet;
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
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

}

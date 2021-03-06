package com.ciber.momentum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonetype")
public class PhoneType implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private int recordId;

    @Column(name = "description")
    private String description;

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

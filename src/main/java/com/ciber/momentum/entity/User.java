package com.ciber.momentum.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@Entity
@Table(name = "user")
public class User implements Serializable, Cloneable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "SSN")
    String ssn;
    @Column(name = "Name")
    String name;
    @Column(name = "gender")
    String gender;
    @Column(name = "age")
    String age;
    @Column(name = "Address")
    String address;
    @Column(name = "PhoneNumber")
    String phoneNumber;
    /* New Columns */
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "userObject", cascade = CascadeType.ALL)
    private List<Address> userAddresses;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "userphone", joinColumns = @JoinColumn(name = "userid", nullable = true, updatable = false),
        inverseJoinColumns =
        { @JoinColumn(name = "phoneid",
            nullable = false, updatable = false) })
    private List<Phone> userPhoneSet;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Address> getUserAddresses()
    {
        return userAddresses;
    }

    public void setUserAddresses(List<Address> userAddresses)
    {
        this.userAddresses = userAddresses;
    }

    public List<Phone> getUserPhoneSet()
    {
        return userPhoneSet;
    }

    public void setUserPhoneSet(List<Phone> userPhoneSet)
    {
        this.userPhoneSet = userPhoneSet;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

}

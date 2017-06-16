package com.ciber.momentum.handler;

import java.util.List;

public class UserResponse
{
    int id;
    String ssn;
    String name;
    String gender;
    String age;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<AddressResponse> userAddresses;
    private List<PhoneResponse> userPhone;
    
    
    private String role;

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

    public List<AddressResponse> getUserAddresses()
    {
        return userAddresses;
    }

    public void setUserAddresses(List<AddressResponse> userAddresses)
    {
        this.userAddresses = userAddresses;
    }

   

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<PhoneResponse> getUserPhone()
    {
        return userPhone;
    }

    public void setUserPhone(List<PhoneResponse> userPhone)
    {
        this.userPhone = userPhone;
    }


}

package com.ciber.momentum.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciber.momentum.entity.Address;
import com.ciber.momentum.entity.Phone;
import com.ciber.momentum.entity.User;
import com.ciber.momentum.handler.AddressResponse;
import com.ciber.momentum.handler.AddressTypeResponse;
import com.ciber.momentum.handler.CountryResponse;
import com.ciber.momentum.handler.PhoneResponse;
import com.ciber.momentum.handler.PhoneTypeResponse;
import com.ciber.momentum.handler.UserPhone;
import com.ciber.momentum.handler.UserResponse;

public class UserDAOHelperImpl implements UserDAOHelper
{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Helper method to migrate
     * @param userList
     * @return
     */
    public List<UserResponse> readUserDetails(List<User> userList)
    {

        List<UserResponse> newUserList = new ArrayList<UserResponse>();
        if (userList == null)
        {
            return newUserList;
        }
        System.out.println("Size of User list: " + userList.size());
        try
        {
            for (User user : userList)
            {
                UserResponse newUser = readUser(user);
                newUserList.add(newUser);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newUserList;
    }

    public UserResponse readUser(User user)
    {

        UserResponse newUser = new UserResponse();
        if (user == null)
        {
            return newUser;
        }
        newUser.setFirstName(user.getFirstName());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        newUser.setGender(user.getGender());
        newUser.setId(user.getId());
        newUser.setLastName(user.getLastName());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setSsn(user.getSsn());
        System.out.println("First Name - " + user.getFirstName()
                           + ", Last Name - " + user.getLastName());
        System.out.println("The size of addresslist is -- "
                           + user.getUserAddresses().size());
        List<Address> addressList = user.getUserAddresses();
        List<AddressResponse> lstAdd = new ArrayList<AddressResponse>();
        for (Address address : addressList)
        {
            AddressResponse add = new AddressResponse();
            add.setAddressId(address.getRecordId());
            AddressTypeResponse addressTypeResponse = new AddressTypeResponse();
            addressTypeResponse.setAddressTypeId(address.getAdrsObject()
                                                        .getRecordId());
            addressTypeResponse.setDescription(address.getAdrsObject()
                                                      .getDescription());
            add.setAddressType(addressTypeResponse.getAddressTypeId());
            // add.setAddressType(address.getAddressType());
            add.setCity(address.getCity());
            add.setLine1(address.getLine1());
            add.setLine2(address.getLine2());
            add.setState(address.getState());
            add.setZip(address.getZip());
            // add.setUserObject(address.getUserObject());
            System.out.println("address is --- " + address.getCity());
            System.out.println("Address Type is --- "
                               + address.getAdrsObject().getDescription());
            lstAdd.add(add);
        }

        newUser.setUserAddresses(lstAdd);

        List<Phone> userPhoneSet = user.getUserPhoneSet();
        List<PhoneResponse> newUserPhoneLst = new ArrayList<PhoneResponse>();
        for (Phone phone : userPhoneSet)
        {

            PhoneResponse newPhone = new PhoneResponse();
            newPhone.setPhoneId(phone.getRecordId());
            newPhone.setPhoneNumber(phone.getPhoneNumber());
            newPhone.setPhoneType(phone.getPhoneType());

            PhoneTypeResponse newPhoneType = new PhoneTypeResponse();
           /* newPhoneType.setPhoneTypeId(phone.getPhType().getRecordId());
            newPhoneType.setDescription(phone.getPhType().getDescription());
*/
            CountryResponse newCountry = new CountryResponse();
           /* newCountry.setCountryCode(phone.getCountry().getCountryCode());
            newCountry.setDescription(phone.getCountry().getDescription());
            newCountry.setCountryId(phone.getCountry().getRecordId());*/
            newPhone.setCountry(newCountry);

            System.out.println("User Phone is --- " + phone.getPhoneNumber());
            System.out.println("User Country is --- " + phone.getCountryId());
            /*System.out.println("Phone Record Id is -- "
                               + phone.getPhType().getRecordId());
            System.out.println("Phone Type is -- "
                               + phone.getPhType().getDescription());
            System.out.println("Country code is ---- "
                               + phone.getCountry().getCountryCode());
            System.out.println("Country description is ---- "
                               + phone.getCountry().getDescription());*/
            newUserPhoneLst.add(newPhone);
        }
        UserPhone userPhone = new UserPhone();
        userPhone.setUserId(user.getId());
        userPhone.setPhoneId(newUserPhoneLst);
        newUser.setUserPhone(newUserPhoneLst);
        return newUser;
    }

   
    /**
     * Method to read list of users by userName
     * @param user
     * @return
     */
    public User getUserByName(String userName) throws Exception
    {

        User user = null;
        try
        {
            Criteria crit = getCurrentSession().createCriteria(User.class);
            if (userName.contains("-"))
                crit.add(Restrictions.eq("ssn", userName));
            else
                crit.add(Restrictions.eq("name", userName));
            user = (User) crit.uniqueResult();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            throw new Exception(e);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            // throw new Exception(e.getMessage(),e.getCause());
            throw new Exception(e);
        }
        return user;
    }
    
    public Session getCurrentSession() throws Exception
    {
        return sessionFactory.getCurrentSession();
    }

}

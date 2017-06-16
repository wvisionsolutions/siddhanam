package com.ciber.momentum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ciber.momentum.dao.UserDAO;
import com.ciber.momentum.entity.Address;
import com.ciber.momentum.entity.Phone;
import com.ciber.momentum.entity.User;
import com.ciber.momentum.handler.UnknownResourceException;
import com.ciber.momentum.handler.UserResponse;
import com.ciber.momentum.helper.UserDAOHelperImpl;

@Repository
/**
 * User imple DAO Class
 * @author ajain
 */
public class UserDAOImpl extends UserDAOHelperImpl implements UserDAO
{

  
    
    public UserDAOImpl()
    {
        super();
    }

    public UserDAOImpl(SessionFactory sessionFactory)
    {
        super();
        sessionFactory = sessionFactory;
    }
    
    @Transactional(readOnly = false)
    /**
     * Method to Add User Data
     * @param user
     * @return
     */
    public boolean addUser(User user) throws Exception
    {
		boolean message = false;
        try
        {
            User tmpUser = new User();
            tmpUser.setFirstName(user.getFirstName());
            tmpUser.setLastName(user.getLastName());
            tmpUser.setGender(user.getGender());
            tmpUser.setPassword(user.getPassword());
            tmpUser.setSsn(user.getSsn());
            tmpUser.setRole(user.getRole());
            tmpUser.setName(user.getName());
            tmpUser.setEmail(user.getEmail());
            tmpUser.setRole("Basic");
            getCurrentSession().save(tmpUser);
            if (user.getUserAddresses() != null)
            {
                List<Address> addressList = user.getUserAddresses();
                for (Address address : addressList)
                {
                    Address add = new Address();
                    add.setAddressType(address.getAddressType());
                    add.setCity(address.getCity());
                    add.setLine1(address.getLine1());
                    add.setLine2(address.getLine2());
                    add.setState(address.getState());
                    add.setZip(address.getZip());
                    add.setUserObject(tmpUser);
                    getCurrentSession().save(add);
                }
            }
            List<Phone> userPhoneSet = user.getUserPhoneSet();
            List<Phone> newPhones = new ArrayList<Phone>();
            for (Phone phone : userPhoneSet)
            {
                Phone newPhone = new Phone();
                newPhone.setPhoneNumber(phone.getPhoneNumber());
                newPhone.setPhoneType(phone.getPhoneType());
                newPhone.setCountryId(phone.getCountryId());
                List<User> arrayPhoneUser = new ArrayList<User>();
                arrayPhoneUser.add(tmpUser);
                newPhone.setUserSet(arrayPhoneUser);
                newPhones.add(newPhone);
                getCurrentSession().save(newPhone);
            }
            tmpUser.setUserPhoneSet(newPhones);
            getCurrentSession().update(tmpUser);
			message=true;
            System.out.println("User Record Saved  for ::" + tmpUser.getFirstName());
        }
        catch (Exception e)
        {
            message=false;
           throw new Exception(e.getMessage(),e.getCause());
        }
		return message;
    }

    /**
     * Method to Update User Data
     * @param user
     * @return
     */
    public boolean updateUser(User user) throws Exception
    {
		boolean message = false;
        try
        {
            getCurrentSession().update(user);
			message=true;
        }
        catch (Exception e)
        {
			message=false;
			 throw new Exception(e.getMessage(),e.getCause());
        }
	  return message;
    }

    /**
     * Method to read user data
     * @param user
     * @return
     */
    public User getUserById(int id) throws Exception
    {
        User user = null;
        try
        {
            user = (User) getCurrentSession().get(User.class, id);
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage(),e.getCause());
        }
        return user;
    }

    /**
     * Method to delete User data by userId
     * @param user
     * @return
     */
    public boolean deleteUser(int userId) throws Exception
    {
        User user = getUserById(userId);
		boolean message = false;
        try
        {
            if (user != null)
                getCurrentSession().delete(user);
				message=true;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
			message=false;
			 throw new Exception(e.getMessage(),e.getCause());
        }
		return message;
    }

    @SuppressWarnings("unchecked")
    /**
     * Method to read all user records
     * @param user
     * @return
     */
    public List<UserResponse> getUsers() throws Exception
    {
        List<UserResponse> userResponse = null;
        try
        {
            List<User> result = getCurrentSession().createQuery("from User")
                                                   .list();
            if (result!=null)
            userResponse = readUserDetails(result);
            

        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            throw new UnknownResourceException("Some Hibernate related exception:" + e.getMessage());
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            throw new Exception(e.getMessage(),e.getCause());
        }
        return userResponse;
    }
    
    @SuppressWarnings("unchecked")
    public List<UserResponse> searchUsers(String userName) throws Exception
    {

        List<User> results = null;
        try
        {
            Criteria cr = getCurrentSession().createCriteria(User.class);
            userName = "%" + userName + "%";
            System.out.println("Search name in DAO Impl " + userName);
            cr.add(Restrictions.like("name", userName));
            results = cr.list();
        }
        catch (HibernateException e)
        {
            throw new Exception(e);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
        return readUserDetails(results);
    }

    
   
}

package com.ciber.momentum.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciber.momentum.dao.UserDAO;
import com.ciber.momentum.entity.User;
import com.ciber.momentum.handler.UnknownResourceException;
import com.ciber.momentum.handler.UserResponse;

@Transactional
@Service("userService")
public class UserService
{

    @Autowired
    private UserDAO userDAO;
    protected static Logger logger = Logger.getLogger("service");

    public UserService()
    {
        super();
    }

    public UserService(UserDAO userDAO)
    {
        super();
        this.userDAO = userDAO;
    }

    /**
     * Retrieves all users
     */
    public List<UserResponse> getAll()
    {
        logger.debug("Retrieving all users");
        try
        {
            return userDAO.getUsers();

        }
        catch (Exception e)
        {
            //any other lookup throws an exception (not found):
            throw new UnknownResourceException("Some database error... Unable to find users records" + e.getMessage());
        }
    }

    /**
     * Retrieves all search users
     */
    public List<UserResponse> searchUsers(String name) throws Exception
    {
        logger.debug("Retrieving all search users by : " + name);
        return userDAO.searchUsers(name);
    }

    /**
     * Retrieves a single user
     */
    public User getUserById(int id) throws Exception
    {
        logger.debug("Retrieving user with id: " + id);

        return userDAO.getUserById(id);

    }

    /**
     * Adds a new user
     */
    public Boolean add(User user) throws Exception
    {
        logger.debug("Adding new user");
        try
        {
            userDAO.addUser(user);
            logger.debug("Added new user");
            return true;
        }
        catch (Exception e)
        {
            logger.error(e);
            return false;
        }
    }

    /**
     * Deletes an existing user
     */
    public Boolean delete(int id) throws Exception
    {
        logger.debug("Deleting user with id: " + id);

        try
        {

            userDAO.deleteUser(id);
            // Deleting Assessment also
            return true;

        }
        catch (Exception e)
        {
            logger.error(e);
            return false;
        }
    }

    /**
     * Edits an existing user
     */
    public Boolean edit(User user) throws Exception
    {
        logger.debug("Editing user with id: " + user.getId());

        try
        {

            userDAO.updateUser(user);
            return true;

        }
        catch (Exception e)
        {
            logger.error(e);
            return false;
        }
    }

    public UserResponse getUser(String userName) throws Exception
    {
         UserResponse userResponse= null;
        try
        {
            List<UserResponse> users = userDAO.searchUsers(userName);
            if(users!=null && users.size()>0){
            return users.get(0);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            throw new Exception(e);
        }
        return userResponse;
    }
   
}

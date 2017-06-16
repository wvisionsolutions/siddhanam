package com.ciber.momentum.helper;

import com.ciber.momentum.entity.User;

public interface UserDAOHelper
{    
      
    /**
     * Method to Search user by userName
     * @param user
     * @return
     */
    public User getUserByName(String userName) throws Exception;
}

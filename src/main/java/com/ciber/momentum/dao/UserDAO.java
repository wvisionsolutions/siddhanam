package com.ciber.momentum.dao;

import java.util.List;

import com.ciber.momentum.entity.User;
import com.ciber.momentum.handler.UserResponse;
import com.ciber.momentum.helper.UserDAOHelper;

public interface UserDAO extends UserDAOHelper  {

    /**
     * Method to Add User Data
     * @param user
     * @return
     */
	public boolean addUser(User user) throws Exception;

	/**
     * Method to Update User Data
     * @param user
     * @return
     */
	public boolean updateUser(User user) throws Exception;

	/**
     * Method to read user data
     * @param user
     * @return
     */
	public User getUserById(int id) throws Exception;

	/**
     * Method to delete User data by userId
     * @param user
     * @return
     */
	public boolean deleteUser(int userId) throws Exception ;

	/**
     * Method to read all user records
     * @param user
     * @return
     */
	public List<UserResponse> getUsers() throws Exception;
	
	  /**
     * Method to read list of users by userName
     * @param user
     * @return
     */
    public List<UserResponse> searchUsers(String userName) throws Exception;

}

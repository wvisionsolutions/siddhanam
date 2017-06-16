package com.ciber.momentum.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ciber.momentum.entity.Login;
import com.ciber.momentum.entity.LoginResponse;
import com.ciber.momentum.entity.Response;
import com.ciber.momentum.entity.User;
import com.ciber.momentum.entity.UserAddResponse;
import com.ciber.momentum.entity.UserList;
import com.ciber.momentum.handler.MomentumHandler;
import com.ciber.momentum.handler.UserResponse;
import com.ciber.momentum.service.UserService;
import com.ciber.momentum.utils.MomentumConstants;

/**
 * REST service provider
 * 
 * Only GET and POST will return values PUT and DELETE will not.
 */
@Controller
public class MomentumProviderController
{

    protected static Logger logger = Logger.getLogger("controller");
    MomentumHandler momentumHandler = new MomentumHandler();

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/getLogin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json", headers = "Accept=application/xml, application/json")
    public @ResponseBody Response validateLogin(@RequestBody Login login,
                                                HttpServletRequest request, HttpServletResponse response)
    {

        LoginResponse res = new LoginResponse();
        logger.debug("Validating login page" + "\nUser Name ="
                     + login.getUserName() + "\npassword=" + login.getPassword());
        System.out.println("Validating login page" + "\nUser Name ="
                           + login.getUserName() + "\npassword=" + login.getPassword());
        // Implemented logic as both username and password are equal and should
        // exist name in User table
        try
        {

            UserResponse userdata = userService.getUser(login.getUserName());

            if (userdata == null || !(login.getPassword().equalsIgnoreCase(userdata.getPassword())))
            {
                res.setSessionId(login.getUserName() + new Random().nextInt(3));
                res.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
                res.setResponseMessage("Incorrect user name or password...");
                return res;
            }
            else
            {
                res.setUserList(userService.getAll());
                res.setResponseData(userdata);
                res.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
                return res;
            }

        }
        catch (Exception e)
        {
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            res.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            res.setResponseMessage("There is some issue, please contact Administrator");
            e.printStackTrace();
            return res;
            
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response getUser()
    {
        logger.debug("Provider has received request to get all users");

        // Call service here
        Response response = new Response();
        UserList result = new UserList();
        try
        {
            result.setData(userService.getAll());

            System.out.println("Checking User size in controller is ::  "
                               + result.getData().size());
            System.out.println("Result ::: " + result.getData().get(0));
            response.setResponseData(result);
            response.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
            return response;
        }
        catch (Exception e)
        {
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;            
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    public @ResponseBody Response getUser(@PathVariable("id") int id)
    {
        logger.debug("Provider has received request to get User with id: " + id);
        Response response = new Response();
        // Call service here
        User user = null;
        ;
        try
        {
            user = userService.getUserById(id);
            response.setResponseData(user);
            response.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
            return response;
        }
        catch (Exception e)
        {
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json", headers = "Accept=application/xml, application/json")
    public @ResponseBody Response addUser(@RequestBody User user)
    {
        Response response = null;
        try
        {
            logger.debug("Provider has received request to add new User");
            response = new UserAddResponse();
            Boolean status = userService.add(user);
            if (status)
            {
                response.setResponseCode(MomentumConstants.USER_ADD_SUCCESS_CODE);
                response.setResponseMessage("User Added Successfully...");
            }
            else
            {
                response.setResponseCode(MomentumConstants.USER_ADD_FAIL_CODE);
                response.setResponseMessage("There is issue in add...");
            }
        }
        catch (Exception e)
        {
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("Incorrect user name or password...");
            return response;

        }
        // Call service to here
        return response;
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
    public @ResponseBody Response updateUser(
                                             @RequestBody UserResponse userResponse)
    {
        logger.debug("Provider has received request to edit User with id: " + userResponse.getId());
        Response response = new Response();
        User user = new User();
        try
        {            
            response.setResponseData(user);
            response.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
            return response;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;
        }
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
    public @ResponseBody Response deleteUser(@PathVariable("id") int id)
    {
        logger.debug("Provider has received request to delete user with id: "
                     + id);
        Response response = new Response();
        // Call service here
        try
        {
            String returnValue = "" + userService.delete(id);
            response.setResponseData(returnValue);
            response.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
            return response;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;
        }
    }

    @RequestMapping(value = "/getUserByName/{userName}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    public @ResponseBody Response getUser(
                                      @PathVariable("ssn") String userName)
    {
        logger.debug("Provider has received request to get User with ssn: "
                     + userName);
        Response response = new Response();
        // Call service here
        UserResponse user;
        try
        {
            user = userService.getUser(userName);
            response.setResponseData(user);
            response.setResponseCode(MomentumConstants.LOGIN_SUCCESS_CODE);
            return response;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.LOGIN_ERROR_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;
        }
    }

    /*
     * 
     */

    @RequestMapping(value = "/searchUser/{name}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    public @ResponseBody Response searchUsersByName(
                                                    @PathVariable("name") String name)
    {
        logger.debug("Provider has received request to search users");
        Response response = new Response();
        // Call service here
        UserList result = new UserList();
        try
        {
            result.setData(userService.searchUsers(name));
            response.setResponseData(result);
            response.setResponseCode(MomentumConstants.USER_SEARCH_SUCCESS_CODE);
            System.out.println("Checking Search User size in controller is ::  "
                + result.getData().size());
            return response;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            logger.info("There is some execption::" + e.getMessage() + "--" + e.getCause());
            response.setResponseCode(MomentumConstants.USER_SEARCH_FAIL_CODE);
            response.setResponseMessage("There is some issue, please contact Administrator");
            return response;
        }
    }

}

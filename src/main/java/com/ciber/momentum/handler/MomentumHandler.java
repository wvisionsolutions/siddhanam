package com.ciber.momentum.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ciber.momentum.entity.Address;
import com.ciber.momentum.entity.Phone;
import com.ciber.momentum.entity.User;

public class MomentumHandler
{
    protected static Logger logger = Logger.getLogger("controller");

    private RestTemplate restTemplate = new RestTemplate();

    public boolean userExist(String ssnId)
    {

        boolean isExist = false;
        User user = new User();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        // Prepare header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);

        user.setSsn(ssnId);

        // Checking if User is already exist in User table

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try
        {
            ResponseEntity<UserResponse> result = restTemplate
                                                              .exchange(
                                                                        "http://localhost:8080/MomentumService/momentum/ssnUser/{ssn}",
                                                                        HttpMethod.GET, entity, UserResponse.class, ssnId);

            if (result.getBody() != null)

                isExist = true;
            else
                isExist = false;

        }
        catch (Exception e)
        {
            logger.error(e);
        }
        return isExist;

    }

    public UserResponse getUserDetails(String name)
    {
        logger.info("Reading User details...");
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);

        // Checking if User is already exist in User table

        HttpEntity<UserResponse> entity = new HttpEntity<UserResponse>(headers);
        try
        {
            ResponseEntity<UserResponse> result = restTemplate
                                                              .exchange(
                                                                        "http://localhost:8080/MomentumService/momentum/ssnUser/{ssn}",
                                                                        HttpMethod.GET, entity, UserResponse.class, name);

            if (result.getBody() != null)
                return (UserResponse) result.getBody();

        }
        catch (Exception e)
        {
            logger.error(e);
            e.printStackTrace();
            return null;
        }
        return null;

    }

    public User readDatabaseUser(UserResponse userResponse)
    {
        User user = new User();

        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        user.setEmail(userResponse.getEmail());
        user.setGender(userResponse.getGender());
        user.setPassword(userResponse.getPassword());
        user.setSsn("11-111-11111");
        user.setRole("admin");

        Address address1 = new Address();
        address1.setAddressType(1);
        address1.setCity("Lucknow");
        address1.setLine1("main 1");
        address1.setLine2("cross 2");
        address1.setState("UP");
        address1.setZip("333333");

        Address address2 = new Address();
        address2.setAddressType(2);
        address2.setCity("Delhi");
        address2.setLine1("main 6");
        address2.setLine2("cross 7");
        address2.setState("BR");
        address2.setZip("676767");

        address1.setUserObject(user);
        address2.setUserObject(user);

        Phone phone1 = new Phone();
        phone1.setPhoneNumber("99999999999");
        phone1.setCountryId(1);
        phone1.setPhoneType(2);

        Phone phone2 = new Phone();
        phone2.setPhoneNumber("9999999999");
        phone2.setCountryId(2);
        phone2.setPhoneType(3);

        List<Phone> phones = new ArrayList<Phone>();
        phones.add(phone1);
        phones.add(phone2);
        user.setUserPhoneSet(phones);

        return user;
    }

}

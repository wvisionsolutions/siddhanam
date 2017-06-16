package com.ciber.momentum.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MomentumServiceClient
{
    public Object callMomentumServiceGet(String urlString, String dataInput)
    {
        Scanner scanner = null;
        String response = "{}";
        try
        {
            URL url = new URL(urlString);
            //URL url = new URL("http://localhost:8080/loginservice/onlogin");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            System.out.println(dataInput);
            OutputStream os = conn.getOutputStream();
            os.write(dataInput.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200)
            {
                scanner = new Scanner(conn.getErrorStream());
                response = "Error From Server \n\n";
            }
            else
            {
                scanner = new Scanner(conn.getInputStream());
                response = "Response From Server \n\n";
            }
            scanner.useDelimiter("\\Z");
            System.out.println(response + scanner.next());
            scanner.close();
            conn.disconnect();

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return (Object) response + scanner.next();
    }

    public Object callMomentumServicePost(String urlString, String dataInput)
    {
        Scanner scanner = null;
        String response = "{}";
        try
        {
            URL url = new URL(urlString);
            //URL url = new URL("http://localhost:8080/loginservice/onlogin");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            System.out.println(dataInput);
            OutputStream os = conn.getOutputStream();
            os.write(dataInput.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200)
            {
                scanner = new Scanner(conn.getErrorStream());
                response = "Error From Server \n\n";
            }
            else
            {
                scanner = new Scanner(conn.getInputStream());
                response = "Response From Server \n\n";
            }
            scanner.useDelimiter("\\Z");
            System.out.println(response + scanner.next());
            scanner.close();
            conn.disconnect();

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return (Object) response + scanner.next();
    }

    public static void main(String[] args)
    {
        /*String dataInput = "{\"id\" : 21,\"ssn\" : \"11-111-11555\",\"name\" : \"Aviral\", \"gender\" : \"M\",\"age\" : null,"
        		+ "\"role\" : \"admin\",\"firstName\" : \"Aviral\",\"lastName\" : \"Jain\","
        		+ "\"password\" : \"Arbind\",\"email\" : \"jain@gmail.com\"}";
        */
        String dataInput = "{\"firstName\":\"sddfdsfsdf1\",\"lastName\":\"fsdfsdf\",\"ssn\":\"1113343456667\",\"name\":\"Manju\",\"password\":\"fsdfsd\",\"email\":\"dfdsfsd@fffsdfsd\",\"gender\":\"M\",\"userAddresses\":[{\"addressType\":\"1\",\"line1\":\"csfdsd\",\"line2\":\"fdsdfds\",\"city\":\"fdsfds\",\"state\":\"3\",\"zip\":\"3432432432\"}],\"userPhoneSet\":[{\"phoneNumber\":\"3423423423\",\"phoneType\":\"2\",\"countryId\":1}]}";

        /*String dataInput="{\"id\" : 21,\"ssn\" : \"11-111-11111\",\"name\" : \"Arbind\", \"gender\" : \"M\",\"age\" : null, \"languages\" : null,"
        		+ "\"disabilities\" : null,\"mobility\" : null,\"employmentStatus\" : \"Y\", \"address\" : null,\"phoneNumber\" : null,"
        		+ " \"skillsandAptitudes\" : null,\"gradeLevel\" : null,\"read\" : \"\u0000\", \"write\" : \"\u0000\",\"role\" : \"admin\","
        		+ "\"firstName\" : \"Arbind\",\"lastName\" : \"Jain\",\"password\" : \"Arbind\",\"email\" : \"jain@gmail.com\",\"userAddresses\" : [ {"
        		+ "\"recordId\" : 0,\"line1\" : null,\"line2\" : null,\"city\" : \"Lucknow\",\"state\" : null,\"zip\" : null,\"addressType\" : 1,\"userObject\" : null,"
        		+ "\"adrsObject\" : null}, {\"recordId\" : 0,\"line1\" : null,\"line2\" : null,\"city\" : \"Delhi\",\"state\" : null,\"zip\" : null,"
        		+ "\"addressType\" : 2,\"userObject\" : null,\"adrsObject\" : null } ]"
        		+ "}";
        System.out.println(dataInput);*/
        System.out.println(dataInput);
        String responseString = (String) new MomentumServiceClient().callMomentumServicePost("http://localhost:8080/MomentumService/momentum/addUser", dataInput);
        //new MomentumServiceClient().callMomentumServiceGet("http://localhost:8080/MomentumService/momentum/ssnUser/Arbind","");
    }
}

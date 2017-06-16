package com.ciber.momentum.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// CXF REST Client Invoking POST Method

public class WebServiceTest
{

    public static void main(String[] args)
    {
        try
        {
           // URL url = new URL("http://localhost:8080/MomentumService/momentum/users");
            URL url = new URL("http://localhost:8080/loginservice/onlogin");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"userName\":\"Arbind\",\"password\":\"Arbind\",\"role\":\"user\"}";
            //String input = "{id:\"1\",userId:\"admin\",password:\"admin\"}";
            // String input = "{\"User\":{\"id\":\"1\",\"userId\":\"admin\",\"password\":\"admin\"}}";
            System.out.println(input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            Scanner scanner;
            String response;
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
    }
}
package com.ciber.momentum.handler;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author ajain
 * Java class to parse response object to JSON String.
 * 
 */
public class JSONProcessor
{
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * CommonResponse object to JSON parser method.
     * @param responeHeader
     * @return
     */
    /*
    public String toJSONResponse(CommonResponse responeHeader)
    {
     ObjectMapper mapper = new ObjectMapper();
     String json = null;
     try
     {
         json = mapper.writeValueAsString(responeHeader);
         log.debug("Parsed JSON response::" + json);
     }
     catch (Exception e)
     {
         throw new RuntimeException(e);
     }
     return json;
    }*/

    /**
     * CommonResponse object to JSON parser method.
     * @param responeHeader
     * @return
     */
    public String toJSONResponse(Object responeHeader)
    {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try
        {
            json = mapper.writeValueAsString(responeHeader);
            log.debug("Parsed JSON response::" + json);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return json;
    }
}

package com.selenium.context.usermanager;

import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class TestUserAccountManager
{
    private static final Logger logger = LoggerFactory.getLogger(TestUserAccountManager.class);

    private static TestUsers testUsers;

    public TestUserAccountManager()
    {
        ObjectMapper mapper = new ObjectMapper();

        ClassLoader classLoader = getClass().getClassLoader();
        URL en = classLoader.getResource("TestUsers.json");

        try
        {
            testUsers = mapper.readValue(new File(en.toURI()), TestUsers.class);
        }
        catch (IOException e)
        {
            logger.info("IOException--->" + e.toString());
            e.printStackTrace();
        }
        catch (URISyntaxException e)
        {
            logger.info("URISyntaxException--->" + e.toString());
            e.printStackTrace();
        }
    }

    public TestUser getTestUser(int index)
    {
        logger.info(String.format("Test User -----> %s ", testUsers.getUsers().get(index).getUsername()));

        try
        {
            return testUsers.getUsers().get(index);
        }
        catch (Exception ex)
        {
            throw new NotFoundException("Test User not Found !!!");

        }
    }
}

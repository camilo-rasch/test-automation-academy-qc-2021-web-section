package com.web.automation.test;

import com.web.automation.data.Data;
import com.web.automation.data.User;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class testDataUsers {

    public Logger log = Logger.getLogger(BaseTest.class);

    @Test(dataProviderClass = Data.class, dataProvider = "user")
    public void testInputUsers(Object[] data){
        User user = (User) data[0];
        log.info(user.getEmail());
    }

    @Test(dataProviderClass = Data.class, dataProvider = "countries")
    public void testInputC(String data){
        log.info(data);
    }

}

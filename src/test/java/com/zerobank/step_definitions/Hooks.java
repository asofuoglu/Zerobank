package com.zerobank.step_definitions;

import com.zerobank.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setup(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @After
    public void teardown(){
        Driver.closeDriver();
    }



}

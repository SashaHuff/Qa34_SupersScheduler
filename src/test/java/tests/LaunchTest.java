package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.awt.*;

public class LaunchTest extends Configuration {
    @Test
    public void launchTest(){

        String version =  new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");
    }
}

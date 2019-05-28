package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.VPLhomePage;

public class invalidLoginTest {

    public static void main (String [] args) {

        String projectPath = System.getProperty( "user.dir" );
        System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();

        VPLhomePage.open(driver);

        VPLhomePage.logToUserDashBoard(driver);

        VPLhomePage.signInWith(driver,"123445", "988777");
        Assert.assertTrue (VPLhomePage.hasError(driver));

        driver.quit();

    }




}

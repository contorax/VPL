package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VPLhomePage {


    WebDriver browserDriver;

    String homePageUrl = "http://www.vpl.ca";
    private static By userDashBoardXpath = By.xpath("//a[contains(text(),'Log In / My VPL')]");
    //private static By barCodeID = By.xpath("//input[@class='field_username text']");
    private static By barCodeID = By.cssSelector("input[class='field_username text']");
    private static By pinID = By.xpath("//input[@name='user_pin']");
    private static By loginXpath = By.xpath ("//input[@title='Log In']");
    private static By errorXpath = By.xpath ("//p[@class='message-text']");
    private static By searchTextBoxId = By.id("edit-search");
    private static By searchButtonLocator = By.id("edit-submit");

    public VPLhomePage (WebDriver driver) {
        browserDriver = driver;
    }


    public static WebElement userDashBoard (WebDriver driver) {
        WebElement element = driver.findElement(userDashBoardXpath);
        return element;
    }

    public static WebElement barCode (WebDriver driver) {
        WebElement element = driver.findElement(barCodeID);
        return element;
    }

    public static WebElement pin (WebDriver driver) {
        WebElement element = driver.findElement(pinID);
        return element;
    }

    public static WebElement login (WebDriver driver) {
        WebElement element = driver.findElement(loginXpath);
        return element;
    }

    private static  WebElement signinError (WebDriver driver)  {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorXpath));
        WebElement element = driver.findElement(errorXpath);

        return element;
    }

    public static void  logToUserDashBoard (WebDriver driver) {
        userDashBoard(driver).sendKeys(Keys.RETURN);
    }


    public static void  signInWith (WebDriver driver, String username, String password) {
        barCode(driver).sendKeys(username);
        pin(driver).sendKeys(password);

        login(driver).sendKeys(Keys.RETURN);
    }
    public  void openPage() {

        browserDriver.get(homePageUrl);
    }

    public void searchForKeyword(String keyword) {
        typeSearchKeyword(keyword);
        executeSearch();
    }

    private void typeSearchKeyword(String keyword) {
        WebElement searchTextBox = browserDriver.findElement(searchTextBoxId);
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(keyword);
    }

    private void executeSearch() {
        WebElement searchTextButton = browserDriver.findElement(searchButtonLocator);
        searchTextButton.click();
    }

    public static boolean hasError (WebDriver driver) {
        boolean isDisplayed = VPLhomePage.signinError(driver).isDisplayed();

        return isDisplayed;
    }

}

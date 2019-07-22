package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.VPLhomePage;
import pages.ResultsPage;

import static junit.framework.TestCase.assertTrue;

public class SearchTest {




    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchReturnsResults() {

        VPLhomePage homePage = new VPLhomePage(driver);
        homePage.openPage();
        homePage.searchForKeyword("java");

        ResultsPage resultsPage = new ResultsPage(driver);
        assertTrue(resultsPage.isOpen() == true);
        assertTrue(resultsPage.resultCount() > 0);

    }




}

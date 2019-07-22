package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    WebDriver browserDriver;

    String resultCountLocator = "//span[@class='items_showing_count']";
    String expectedResultsPageTitle = "Search | Vancouver Public Library | BiblioCommons";
    String expectedResultsPageUrl = "https://vpl.bibliocommons.com/search?q=java&t=keyword";

    public ResultsPage(WebDriver driver) {
        browserDriver = driver;
    }

    public boolean isOpen() {
        boolean isTitleCorrect = browserDriver.getTitle()
                .equalsIgnoreCase(
                        expectedResultsPageTitle);
        boolean isUrlCorrect = browserDriver.getCurrentUrl()
                .equalsIgnoreCase(
                        expectedResultsPageUrl);

        return isTitleCorrect && isUrlCorrect;
    }

    public int resultCount() {
        WebElement resultCountLabel = browserDriver.findElement(
                By.xpath(resultCountLocator));

        String resultCountText = resultCountLabel.getText();
        return extractNumberFromResultCountText(resultCountText);
    }

    private int extractNumberFromResultCountText(String resultCountText) {
        int startIndex = resultCountText.indexOf("of") + 3;
        int endIndex = resultCountText.indexOf(" items");
        return Integer.parseInt(resultCountText
                .substring(startIndex, endIndex));
    }



}

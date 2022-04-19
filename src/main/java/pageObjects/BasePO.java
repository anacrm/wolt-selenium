package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalVars;

import java.time.Duration;
import java.util.List;

public class BasePO {

    //creating a constructor
    public BasePO() {
        PageFactory.initElements(getDriver(), this);
    }

    //creating a method to get a driver
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    //creating a method to navigate URL
    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }


    public void sendKeys(WebElement element, String textToType) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }


    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndValidateUrl(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.urlContains(url));
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(url));
    }

    public void waitForWebElementAndValidateUrl(String url1, String url2) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(url1),
                ExpectedConditions.urlContains(url2))
        );
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(url1) || currentUrl.contains(url2));

    }

    public void waitForListWebElementAndValidateContent(List<WebElement> list) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));

        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
    }
}

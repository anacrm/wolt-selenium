package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

import java.util.List;

public class DiscoveryPO extends BasePO {
    public DiscoveryPO() {
        super();
    }

    private @FindBy(xpath = "//*[text()='Accept']")
    WebElement acceptCookiesButton;

    private @FindBy(xpath = "//*[@id=\"mainContent\"]/nav/div/div[2]/div[2]/div/div[2]/a")
    WebElement restaurantButton;

    private @FindBy(className = "VenueVerticalList__Grid-sc-1g9lh7x-1")
    WebElement parentElementRestaurants;

    private @FindBy(xpath = "//*[@id=\"mainContent\"]/nav/div/div[2]/div[2]/div/div[3]/a")
    WebElement storesButton;

    private @FindBy(className = "VenueVerticalList__Grid-sc-1g9lh7x-1")
    WebElement parentElementStores;

    public void navigateToDiscoveryPage() {
        navigateTo_URL(GlobalVars.WEBSITE_BASE_URL + "/en/discovery");
    }

    public void clickAcceptCookiesButton() {
        waitForWebElementAndClick(acceptCookiesButton);
    }

    public void clickRestaurantButton() {
        waitForWebElementAndClick(restaurantButton);
    }

    public void validateGridRestaurants() {
        List<WebElement> allChildRestaurants = parentElementRestaurants.findElements(By.xpath("*"));
        waitForListWebElementAndValidateContent(allChildRestaurants);
        System.out.println(allChildRestaurants.size());
    }

    public void clickStoresButton() {
        waitForWebElementAndClick(storesButton);
    }

    public void validateGridStores() {
        List<WebElement> allChildStores = parentElementStores.findElements(By.xpath("*"));
        waitForListWebElementAndValidateContent(allChildStores);
        System.out.println(allChildStores.size());

    }

    public void clickARestaurant() {
        List<WebElement> allChildRestaurants = parentElementRestaurants.findElements(By.xpath("*"));
        WebElement restaurant = allChildRestaurants.get(0);
        restaurant.click();
    }

}

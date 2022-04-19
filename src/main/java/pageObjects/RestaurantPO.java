package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.GlobalVars;

import java.util.List;

public class RestaurantPO extends BasePO {

    public RestaurantPO() {
        super();
    }

    private @FindBy(xpath = "//*[text()='Accept']")
    WebElement acceptCookiesButton;

    private @FindBy(xpath = "//div[@role = 'listitem']")
    List<WebElement> menuItems;

    private @FindBy(xpath = "//*[text()='Add to order']")
    WebElement buttonUpdateOrder;

    private @FindBy(className = "CartViewButton__LabelWithPrice-sc-8iz5bz-3")
    WebElement cartView;

    private @FindBy(className = "CartViewButton__Price-sc-8iz5bz-2")
    WebElement cartViewPrice;

    private @FindBy(id = "product-option-form")
    WebElement optionForm;

    private @FindBy(xpath = "//*[text()='Required']")
    WebElement requiredAlert;

    public void navigateToWoltRestaurant() {

        navigateTo_URL(GlobalVars.WEBSITE_BASE_URL + "/en/fin/vantaa/restaurant/subway-koivuhaka");
    }

    public void clickAcceptCookiesButton() {
        waitForWebElementAndClick(acceptCookiesButton);
    }

    public void chooseMenuItem() {


        WebElement menuItem = menuItems.get(55);
        menuItem.click();

    }

    public void chooseMenuItem(int itemIndex) {

        WebElement menuItem = menuItems.get(itemIndex);
        menuItem.click();
    }

    public void clickUpdateOrderButton() {

        waitForWebElementAndClick(buttonUpdateOrder);
    }

    public void checkCartView(String expectedPrice) {

        String currentPrice = cartViewPrice.getText();
        Assert.assertEquals(expectedPrice, currentPrice);

    }

    public void optionFormIsAvailable() {
        waitFor(optionForm);
        Assert.assertTrue(optionForm.isDisplayed());
    }

    public void checkRequiredMessage() {
        waitFor(requiredAlert);
        Assert.assertTrue(requiredAlert.isDisplayed());
    }
}




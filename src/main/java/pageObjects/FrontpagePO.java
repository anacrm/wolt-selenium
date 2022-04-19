package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;


public class FrontpagePO extends BasePO {

    public FrontpagePO() {
        super();
    }

    private @FindBy(id = "front-page-input")
    WebElement addressBox;

    private @FindBy(xpath = "//*[text()='Search']")
    WebElement searchButton;

    private @FindBy(xpath = "//*[text()='Tikkurila']")
    WebElement addressSearch;

    private @FindBy(xpath = "//*[text()='Accept']")
    WebElement acceptCookiesButton;

    private @FindBy(xpath = "//*[text()='Use my current location']")
    WebElement currentLocation;

    private @FindBy(xpath = "//*[contains(text(),'or view popular restaurants')]")
    WebElement viewPopular;


    public void navigateToFrontpage() {
        navigateTo_URL(GlobalVars.WEBSITE_BASE_URL + "/en/fin");
    }

    public void setSpecificAddress(String address) {
        sendKeys(addressBox, address);
    }

    public void clickSearchButton() {
        waitForWebElementAndClick(searchButton);
    }

    public void selectAddressSearch() {
        waitForWebElementAndClick(addressSearch);
    }

    public void clickAcceptCookiesButton() {
        waitForWebElementAndClick(acceptCookiesButton);
    }

    public void clickOnAddressBox() {
        waitForWebElementAndClick(addressBox);
    }

    public void clickOnCurrentLocation() {
        waitForWebElementAndClick(currentLocation);
    }

    public void clickViewPopularLinkButton() {
        waitForWebElementAndClick(viewPopular);
    }

    public void validateRedirect(String url) {
        waitForWebElementAndValidateUrl(url);
    }

    public void validateRedirectOr(String url1, String url2) {

        waitForWebElementAndValidateUrl(url1, url2);
    }


}

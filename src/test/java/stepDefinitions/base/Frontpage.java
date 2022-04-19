package stepDefinitions.base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FrontpagePO;


public class Frontpage extends FrontpagePO {

    @Given("I access the frontpage")

    public void iAccessTheFrontPage() {
        navigateToFrontpage();
    }

    @When("I accept the cookies from frontpage")
    public void iAcceptTheCookies() {
        clickAcceptCookiesButton();
    }

    @And("I enter a specific address {}")
    public void iEnterASpecificAddress(String address) {
        setSpecificAddress(address);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        clickSearchButton();
    }

    @And("Select the address")
    public void selectTheAddress() {
        selectAddressSearch();
    }

    @Then("I should be redirected to {}")
    public void iShouldBeRedirectedTo(String pageUrl) {
        validateRedirect(pageUrl);
    }

    @Then("I should be redirected either to {} or {}")
    public void iShouldBeRedirectedToOr(String pageUrl1, String pageUrl2) {
        validateRedirectOr(pageUrl1, pageUrl2);
    }

    @When("I Click on use my current location")
    public void iClickOnUseMyCurrentLocation() {
        clickOnCurrentLocation();
    }

    @And("I click on the address box")
    public void clickOnTheAddressBox() {
        clickOnAddressBox();
    }

    @When("I Click on view popular link button")
    public void i_click_on_view_popular_link_button() {
        clickViewPopularLinkButton();
    }


}

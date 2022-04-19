package stepDefinitions.base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DiscoveryPO;

public class Discovery extends DiscoveryPO {

    @Given("I access the Discovery page")
    public void iAccessTheDiscoveryPage() {
        navigateToDiscoveryPage();
    }

    @When("I accept the cookies from discovery page")
    public void iAcceptTheCookiesFromDiscoveryPage() {
        clickAcceptCookiesButton();
    }

    @When("I click on Restaurants button")
    public void iClickOnRestaurantsButton() {
        clickRestaurantButton();
    }

    @Then("I should be present to a list of restaurants")
    public void iShouldBePresentToAListOfRestaurants() {
        validateGridRestaurants();
    }

    @When("I click on Stores button")
    public void iClickOnStoresButton() {
        clickStoresButton();
    }

    @Then("I should be present to a list of Stores")
    public void iShouldBePresentToAListOfStores() {
        validateGridStores();
    }

    @When("I click a restaurant")
    public void iClickARestaurant() {
        clickARestaurant();
    }


}

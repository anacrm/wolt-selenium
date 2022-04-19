package stepDefinitions.base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RestaurantPO;

public class Restaurant extends RestaurantPO {

    @Given("I access the specific restaurant page")
    public void iAccessTheSpecificRestaurantPage() {
        navigateToWoltRestaurant();
    }

    @When("I accept the cookies from restaurant page")
    public void iAcceptTheCookiesFromRestaurantPage() {
        clickAcceptCookiesButton();
    }

    @And("I Choose an item on the menu")
    public void iChooseAItemOnTheMenu() {
        chooseMenuItem();
    }

    @And("I Choose an item on the menu {int}")
    public void iChooseAIitemOnTheMenu(int itemIndex) {
        chooseMenuItem(itemIndex);
    }

    @And("I click on add order button")
    public void iClickOnAddOrderButton() {
        clickUpdateOrderButton();
    }

    @Then("The cart view button should show the price {}")
    public void theCartViewButtonShouldBeUpdated(String price) {
        checkCartView(price);

    }

    @Then("The option form should to keep available and required message be presented")
    public void theOptionFormShouldToKeepAvailableAndRequiredMessageBePresented() {
        optionFormIsAvailable();
        checkRequiredMessage();

    }
}

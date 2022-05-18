package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.automation.framework.cucumber.constants.Constants.*;

public class StorePageTest {

    @Given("After opening the application click on the store tab menu")
    public void after_opening_the_application_click_on_the_store_tab_menu() {
        Waits.forLoading(50);
        Waits.forElementToBeDisplayed(30, HOME_PAGE.isAccountTabDisplayed(), "Account tab ");
        HOME_PAGE.ClickStoreMenu();
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
    }

    @When("Browse by Categories select {string}")
    public void browse_by_categories_select(String Category) {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        for (int i = 0; i < STORE_PAGE.getAllOptionsFromDropDown().size(); i++) {
            String options = STORE_PAGE.getAllOptionsFromDropDown().get(i).getText();
            if (options.contains(Category)) {
                STORE_PAGE.selectOptionFromDropDown(options);
            }
        }
    }

    @Then("All the items displays should be of {string}")
    public void all_the_items_displays_should_be_of_men(String category) {
        for (WebElement categoryTags : STORE_PAGE.getAllCategoryTags()) {
            if (STORE_PAGE.getAllCategoryTags().equals(category)) {
                continue;
            } else {
                Assert.assertEquals(categoryTags.getText(), category);
            }
        }
    }

    @When("Adjust the filter to certain price")
    public void adjust_the_filter_to_certain_price() {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        STORE_PAGE.changeFilterMaxValue();
        STORE_PAGE.clickFilterButton();
    }

    @Then("results should not be greater than the max price filter")
    public void results_should_not_be_greater_than_the_max_price_filter() {
        float maxFilterValue = Float.parseFloat(STORE_PAGE.getMaxFilterPriceValue().replace("$", ""));
        for (WebElement priceTags : STORE_PAGE.getAllProductPrice()) {
            float productPrice = Float.parseFloat(priceTags.getText().replace("$", ""));
            if (productPrice <= maxFilterValue) {
                continue;
            } else {
                Assert.assertEquals(productPrice, maxFilterValue);
            }
        }
    }

    @When("Search for {string}")
    public void search_for(String product) {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        STORE_PAGE.enterSearchElement(product);

        STORE_PAGE.clickSearchButton();
    }

    @Then("Search result should return {string}")
    public void search_result_should_return(String product) {
        for (WebElement productNameElement : STORE_PAGE.getAllProductNames()) {
            String productName = productNameElement.getText();
            if (productName.contains(product)) {
                continue;
            } else {
                Assert.assertEquals(productName, product);
            }
        }
    }

    @Given("Open the Application  and select the Mens section")
    public void open_the_application_and_select_the_mens_section() {
        HOME_PAGE.ClickMenMenu();
        Waits.forElementToBeDisplayed(30, STORE_PAGE.IsBlueJeansToCartButtonDisplayed(),"Add tp cart button for the Blue Jeans ");

    }
    @When("Selecting the Basic Blue Jeans in the mens section")
    public void selecting_the_basic_blue_jeans_in_the_mens_section() throws InterruptedException {
        STORE_PAGE.addBlueJeansToCart();
        Waits.sleep(2000);
    }
    @Then("{int} item is added to the Shopping cart")
    public void item_is_added_to_the_shopping_cart(int sizeOfShoppingCart)  {
        Assert.assertEquals(STORE_PAGE.getNumberOfItemsInCart(),sizeOfShoppingCart);
    }

    @When("Selecting the Basic Blue Jeans of {int} quantity  in the mens section")
    public void selecting_the_basic_blue_jeans_of_quantity_in_the_mens_section(int quantity) throws InterruptedException {
        STORE_PAGE.addBlueJeansToCart();
        Waits.sleep(2000);
        STORE_PAGE.selectingBlueJeansMoreThanOneQuantity(quantity-1);
        Waits.sleep(2000);
    }
    @Then("{int} item Should added to the Shopping cart")
    public void item_should_added_to_the_shopping_cart(int quantity) {
        Assert.assertEquals(STORE_PAGE.getNumberOfItemsInCart(),quantity);
    }

}

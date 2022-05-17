package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import static com.automation.framework.cucumber.constants.Constants.*;

public class SearchAndFilterTest {

    @Given("After opening the application click on the store tab menu")
    public void after_opening_the_application_click_on_the_store_tab_menu() {
        Waits.forLoading(50);
        Waits.forElementToBeDisplayed(30, HOME_PAGE.isAccountTabDisplayed(), "Account tab ");
        HOME_PAGE.ClickStoreMenu();
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
    }

    @Then("Browse by Categories select {string}")
    public void browse_by_categories_select(String Category) {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        for (int i = 0; i < STORE_PAGE.getAllOptionsFromDropDown().size(); i++) {
            String options = STORE_PAGE.getAllOptionsFromDropDown().get(i).getText();
            if (options.contains(Category)) {
                STORE_PAGE.selectOptionFromDropDown(options);
            }
        }
    }

    @And("All the items displays should be of {string}")
    public void all_the_items_displays_should_be_of_men(String category) {
        for (WebElement categoryTags : STORE_PAGE.getAllCategoryTags()) {
            if (STORE_PAGE.getAllCategoryTags().equals(category)) {
                continue;
            } else {
                Assert.assertEquals(categoryTags.getText(), category);
            }
        }
    }

    @Then("Adjust the filter to certain price")
    public void adjust_the_filter_to_certain_price() {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        STORE_PAGE.changeFilterMaxValue();
        STORE_PAGE.clickFilterButton();
    }

    @And("results should not be greater than the max price filter")
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

    @Then("Search for {string}")
    public void search_for(String product) {
        Waits.forElementToBeDisplayed(30, STORE_PAGE.isFilterDisplayed(), "Filter tab ");
        STORE_PAGE.enterSearchElement(product);

        STORE_PAGE.clickSearchButton();
    }

    @And("Search result should return {string}")
    public void search_result_should_return(String product) {
       for(WebElement productNameElement : STORE_PAGE.getAllProductNames()){
        String productName = productNameElement.getText();
        if (productName.contains(product)){
            continue;
        }else{
            Assert.assertEquals(productName,product);
        }
       }
    }
}

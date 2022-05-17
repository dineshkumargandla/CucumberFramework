package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class StorePage {
    public StorePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//select[@id='product_cat']")
    private WebElement CategoryDropDown;

    @FindBy(xpath = "//li[@class='ast-col-sm-12 ast-article-post astra-woo-hover-swap product type-product post-1198 status-publish first instock product_cat-accessories product_cat-women has-post-thumbnail sale featured taxable shipping-taxable purchasable product-type-simple']//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart'][contains(text(),'Add to cart')]")
    private WebElement AddToCartButton;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement FilterButton;

    @FindBy(xpath = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]")
    private WebElement FilterMaxValue;

    @FindBy(xpath = "//span[@class='to']")
    private WebElement MaxFilterValue;

    @FindBy(xpath = "//input[@id='woocommerce-product-search-field-0']")
    private WebElement SearchTextBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement SearchButton;

    public List<WebElement> getAllOptionsFromDropDown() {
        Select se = new Select(driver.findElement(By.xpath("//select[@id='product_cat']")));
        return se.getOptions();
    }

    public void selectOptionFromDropDown (String category) {
        Select se = new Select(driver.findElement(By.xpath("//select[@id='product_cat']")));
        se.selectByVisibleText(category);
    }

    public void  clickAddToCartButton() {
        AddToCartButton.click();
    }

    public void clickFilterButton() {
         FilterButton.click();
    }

    public List<WebElement> getAllCategoryTags(){
        List<WebElement> element = driver.findElements(By.xpath("//span[@class='ast-woo-product-category']"));
        return element;
    }

    public WebElement isFilterDisplayed() {
        return FilterMaxValue;
    }

    public void changeFilterMaxValue() {
        for (int i =0 ; i <10 ; i++){
            FilterMaxValue.sendKeys(Keys.ARROW_LEFT);
        }
    }
    public String getMaxFilterPriceValue(){
        return MaxFilterValue.getText();
    }

    public List<WebElement> getProductTag(){
        List<WebElement> element = driver.findElements(By.xpath("//span[@class='ast-woo-product-category']"));
        return element;
    }

    public List<WebElement> getAllProductPrice(){
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='products columns-4']//span[@class='woocommerce-Price-amount amount']"));
        return element;
    }

    public void enterSearchElement(String searchFor){
        SearchTextBox.clear();
        SearchTextBox.sendKeys(searchFor);
    }
    public void clickSearchButton(){
        SearchButton.click();
    }

    public List<WebElement> getAllProductNames(){
        List<WebElement> element = driver.findElements(By.xpath("//h2[@class='woocommerce-loop-product__title']"));
        return element;
    }
}

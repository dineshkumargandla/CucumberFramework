package com.automation.framework.cucumber.Pages;

import com.automation.framework.cucumber.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.automation.framework.cucumber.constants.Constants.BASE_PAGE;
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

    @FindBy(xpath = "//li[@class='ast-col-sm-12 ast-article-post astra-woo-hover-swap product type-product post-1205 status-publish first instock product_cat-men product_cat-mens-jeans has-post-thumbnail sale featured taxable shipping-taxable purchasable product-type-simple']//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart'][contains(text(),'Add to cart')]")
    private WebElement AddingBlueJeansToCart;

    @FindBy(xpath = "//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart added']")
    private WebElement AddingMultipleBlueJeansToCart;
    @FindBy(xpath = "//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//span[@class='count']")
    private WebElement CartBag;


    public List<WebElement> getAllOptionsFromDropDown() {
        Select se = new Select(driver.findElement(By.xpath("//select[@id='product_cat']")));
        BASE_PAGE.highlight(driver, (WebElement) se);
        return se.getOptions();
    }

    public void selectOptionFromDropDown (String category) {
        Select se = new Select(driver.findElement(By.xpath("//select[@id='product_cat']")));
        BASE_PAGE.highlight(driver, (WebElement) se);
        se.selectByVisibleText(category);
    }

    public void  clickAddToCartButton() {
        BASE_PAGE.highlight(driver, AddToCartButton);
        AddToCartButton.click();
    }

    public void clickFilterButton() {
        BASE_PAGE.highlight(driver, FilterButton);
         FilterButton.click();
    }

    public List<WebElement> getAllCategoryTags(){
        List<WebElement> element = driver.findElements(By.xpath("//span[@class='ast-woo-product-category']"));
        BASE_PAGE.highlight(driver, (WebElement) element);
        return element;
    }

    public WebElement isFilterDisplayed() {
        BASE_PAGE.highlight(driver, FilterMaxValue);
        return FilterMaxValue;
    }

    public void changeFilterMaxValue() {
        BASE_PAGE.highlight(driver, FilterMaxValue);
        for (int i =0 ; i <10 ; i++){
            FilterMaxValue.sendKeys(Keys.ARROW_LEFT);
        }
    }
    public String getMaxFilterPriceValue(){
        BASE_PAGE.highlight(driver, MaxFilterValue);
        return MaxFilterValue.getText();
    }

    public List<WebElement> getProductTag(){
        List<WebElement> element = driver.findElements(By.xpath("//span[@class='ast-woo-product-category']"));
        BASE_PAGE.highlight(driver, (WebElement) element);
        return element;
    }

    public List<WebElement> getAllProductPrice(){
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='products columns-4']//span[@class='woocommerce-Price-amount amount']"));
        BASE_PAGE.highlight(driver, (WebElement) element);
        return element;
    }

    public void enterSearchElement(String searchFor){
        BASE_PAGE.highlight(driver, SearchTextBox);
        SearchTextBox.clear();
        SearchTextBox.sendKeys(searchFor);
    }
    public void clickSearchButton(){
        BASE_PAGE.highlight(driver, SearchButton);
        SearchButton.click();
    }

    public List<WebElement> getAllProductNames(){
        List<WebElement> element = driver.findElements(By.xpath("//h2[@class='woocommerce-loop-product__title']"));
        BASE_PAGE.highlight(driver, (WebElement) element);
        return element;
    }

    public void addBlueJeansToCart(){
        BASE_PAGE.highlight(driver, AddingBlueJeansToCart);
        AddingBlueJeansToCart.click();
    }

    public int getNumberOfItemsInCart(){
        BASE_PAGE.highlight(driver, CartBag);
        return Integer.parseInt(CartBag.getText());
    }

    public WebElement IsBlueJeansToCartButtonDisplayed(){
        return AddingBlueJeansToCart;
    }

    public void selectingBlueJeansMoreThanOneQuantity(int quantity) throws InterruptedException {
        BASE_PAGE.highlight(driver, AddingMultipleBlueJeansToCart);
        for (int i=0 ; i < quantity; i++){
            Waits.sleep(2000);
            AddingMultipleBlueJeansToCart.click();
        }
    }

    public void clickOnShoppingCart(){
        BASE_PAGE.highlight(driver, CartBag);
        CartBag.click();
    }
}

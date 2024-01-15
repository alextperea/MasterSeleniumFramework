package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    @FindBy(how = How.ID, using = "woocommerce-product-search-field-0") private WebElement searchField;
    @FindBy(how = How.CSS, using = "button[value='Search']") private WebElement searchBtn;
    @FindBy(how = How.CSS, using = ".woocommerce-products-header__title.page-title") private WebElement title;
    @FindBy(how = How.CSS, using = "a[title='View cart']") private WebElement viewCartLink;

    //----------------------------------------------------------------------------------------------------
    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //----------------------------------------------------------------------------------------------------
    public StorePage search(String txt) {
        enterTextInSearchField(txt).clickSearchBtn();
        return this;
    }

    private StorePage enterTextInSearchField(String txt) {
        searchField.clear();
        searchField.sendKeys(txt);
        return this;
    }

    private StorePage clickSearchBtn() {
        searchBtn.click();
        return this;
    }
    public String getTitle() {
        return title.getText();
    }

    public StorePage clickAddToCartBtn(String productName) {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartBtn).click();
        return this;
    }
    public CartPage clickViewCart() {
        waitForVisibilityOfElement(viewCartLink).click();
        return new CartPage(driver);
    }
}

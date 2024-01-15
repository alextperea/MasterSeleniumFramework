package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    @FindBy(how = How.CSS, using = "td[class='product-name'] a") private WebElement productName;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Proceed to checkout']") @CacheLookup private WebElement checkoutBtn;

    //-----------------------------------------------------------------------------------------------------
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //-----------------------------------------------------------------------------------------------------
    public String getProductName() {
        return productName.getText();
    }
    public CheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}


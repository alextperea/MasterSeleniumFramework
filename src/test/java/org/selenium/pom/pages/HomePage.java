package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = "li[id='menu-item-1227'] a[class='menu-link']") private WebElement storeMenuLink;

    //-----------------------------------------------------------------------------------------------
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //-----------------------------------------------------------------------------------------------
    public StorePage clickStoreMenuLink() {
        storeMenuLink.click();
        return new StorePage(driver);
    }
}
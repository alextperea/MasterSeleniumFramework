package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.selenium.pom.pages.HomePage;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    //----------------------------------------------------------------------------------
    public BasePage(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //---------------------------------------------------------------------------------
    public HomePage load (){
        driver.get("https://askomdch.com");
        return (HomePage) this;
    }
    public WebElement waitForVisibilityOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void selectOptionFromDropDown(By dropdownLocator, String visibleText) {
        Select select = new Select(driver.findElement(dropdownLocator));
        select.selectByVisibleText(visibleText);
    }
}



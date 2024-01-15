package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    @FindBy(how = How.ID, using = "billing_first_name") private WebElement firstNameTxt;
    @FindBy(how = How.ID, using = "billing_last_name") private WebElement lastNameTxt;
    @FindBy(how = How.ID, using = "billing_company") private WebElement billingCompanyTxt;
    @FindBy(how = How.ID, using = "billing_address_1") private WebElement streetAddressTxt;
    @FindBy(how = How.ID, using = "billing_city") private WebElement cityTxt;
    @FindBy(how = How.ID, using = "billing_postcode") private WebElement zipCodeTxt;
    @FindBy(how = How.ID, using = "billing_phone") private WebElement phoneNumberTxt;
    @FindBy(how = How.ID, using = "billing_email") private WebElement emailTxt;
    @FindBy(how = How.ID, using = "place_order") private WebElement placeOrderBtn;
    @FindBy(how = How.XPATH, using = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']") private WebElement successMessage;
    @FindBy(how = How.ID, using = "select2-billing_country-container") private WebElement countryDropDown;
    @FindBy(how = How.ID, using = "billing_state") private WebElement stateDropDown;
    @FindBy(how = How.ID, using = "payment_method_bacs") private WebElement directBankTransferRadioBtn;

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    public CheckoutPage setBillingInformation(BillingAddress billingAddress) {
        // Here we use the POJO we created.
        enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterBillingCompany(billingAddress.getBillingCompany()).
               // selectCountry().
                enterStreetAddress(billingAddress.getStreetAddress()).
                enterCity(billingAddress.getCity()).
                enterZipCode(billingAddress.getZipCode()).
                enterPhoneNumber(billingAddress.getPhoneNumber()).
                enterEmail(billingAddress.getEmail());
        return this;
    }
    public CheckoutPage enterFirstName(String firstName) {
        firstNameTxt.clear();
        firstNameTxt.sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName) {
        lastNameTxt.clear();
        lastNameTxt.sendKeys(lastName);
        return this;
    }
    public CheckoutPage enterBillingCompany(String companyName) {
        billingCompanyTxt.clear();
        billingCompanyTxt.sendKeys(companyName);
        return this;
    }
    public CheckoutPage selectCountry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropDown));
        countryDropdown.click();

        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/form[3]/div[1]/div[1]/div[1]/div[1]/p[4]/span[1]/span[1]/span[1]/span[1]/span[1]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", country);
        country.click();

        return this;
    }
    public CheckoutPage enterStreetAddress(String address) {
        streetAddressTxt.clear();
        streetAddressTxt.sendKeys(address);
        return this;
    }
    public CheckoutPage selectState(String stateName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(stateDropDown));

        Select select = new Select(stateDropdown);
        select.selectByVisibleText(stateName);

        return this;
    }
    public CheckoutPage enterCity(String city) {
        cityTxt.clear();
        cityTxt.sendKeys(city);
        return this;
    }
    public CheckoutPage enterZipCode(String zipCode) {
        zipCodeTxt.clear();
        zipCodeTxt.sendKeys(zipCode);
        return this;
    }

    public CheckoutPage enterPhoneNumber(String phoneNumber) {
        phoneNumberTxt.clear();
        phoneNumberTxt.sendKeys(phoneNumber);
        return this;
    }
    public CheckoutPage enterEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CheckoutPage selectDirectOrderBankTransfer() {
        WebElement radioBtn = waitForVisibilityOfElement(directBankTransferRadioBtn);
        if (!radioBtn.isSelected()) {
            radioBtn.click();
        }
        return this;
    }
    public CheckoutPage clickPlaceOrderBtn() {
        WebElement button = placeOrderBtn;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", button);
        return this;
    }
    public String getSuccessMessage() {
        return waitForVisibilityOfElement(successMessage).getText();
    }
}


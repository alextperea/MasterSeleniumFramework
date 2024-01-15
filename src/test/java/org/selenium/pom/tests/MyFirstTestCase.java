package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        BillingAddress billingAddress = new BillingAddress(
                "Alejandro",
                "Topete ",
                "Zubale",
                "Mexico",
                "Mar Caspio 1966",
                "Guadalajara",
                "Jalisco",
                "44210",
                "3318967630",
                "alextopeteperea@gmail.com" );

        StorePage storePage = new HomePage(getDriver()).
                                    load().
                                    clickStoreMenuLink().
                                    search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.getTitle();
        storePage.clickAddToCartBtn("Blue Shoes");

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.
                setBillingInformation(billingAddress).
                selectDirectOrderBankTransfer().
                clickPlaceOrderBtn();
        Assert.assertEquals(checkoutPage.getSuccessMessage(),"Thank you. Your order has been received.");

    }

    @Test
    public void guestCheckoutUsingJacksonAPI() throws InterruptedException, IOException {
        String searchFor = "Blue";

        //La función deserializeJson deserializa el JSON del InputStream y lo almacena en el objeto billingAddress.
        // El resultado de la deserialización se asigna nuevamente a la variable billingAddress.
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(getDriver()).
                load().
                clickStoreMenuLink().
                search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”");
        storePage.getTitle();
        storePage.clickAddToCartBtn(product.getName());

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.
                setBillingInformation(billingAddress).
                selectDirectOrderBankTransfer().
                clickPlaceOrderBtn();
        Assert.assertEquals(checkoutPage.getSuccessMessage(),"Thank you. Your order has been received.");

    }
}

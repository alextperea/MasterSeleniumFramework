package org.selenium.pom.base;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    protected WebDriver getDriver(){
        return this.driver.get();
    }
//--------------------------------------------------------
    @Parameters("browser") // esto se usa solamente para correr tests desde el archivo de testng.xml
    @BeforeClass
    public void startDriver(String browser){
    setDriver(new DriverManager().initializeDriver(browser));
    System.out.println("CURRENT THREAD: "+ Thread.currentThread().getId() + ", "+ "DRIVER = "+ getDriver());
    }

    @AfterClass
    public void quitDriver(){
    getDriver().quit();
    }
}

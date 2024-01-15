package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;


public class DriverManager {
    public WebDriver initializeDriver(String browser){

        WebDriver driver;
        String localBrowser;
        localBrowser = System.getProperty("browser", browser); // this is for maven command line
        //localBrowser = browser; // this is for using with .xml file
        switch (DriverType.valueOf(localBrowser)){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: "+ browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}

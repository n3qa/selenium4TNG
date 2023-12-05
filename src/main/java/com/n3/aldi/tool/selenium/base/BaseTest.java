package com.n3.aldi.tool.selenium.base;

import com.n3.aldi.tool.selenium.factory.BrowserDriverFactory;
import com.n3.aldi.tool.selenium.factory.GridDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @Parameters({ "browser", "environment", "platform" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, @Optional("local") String environment, @Optional("WIN10") String platform, ITestContext ctx) {
        log = LogManager.getLogger(ctx.getCurrentXmlTest().getSuite().getName());

        switch (environment) {
            case "local":
                driver = new BrowserDriverFactory(browser, log).createDriver();
                break;

            case "grid":
                driver = new GridDriverFactory(browser, log).createDriver();
                break;

            default:
                driver = new BrowserDriverFactory(browser, log).createDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        driver.quit();
    }

}

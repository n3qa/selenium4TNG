package com.n3.aldi.tool.selenium.factory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class GridDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private String platform;
    private Logger log;
    public GridDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.platform = platform;
        this.log = log;
    }

    public WebDriver createDriver() {
        // Create driver
        log.info("Connecting to the Node with driver: " + browser);
        DesiredCapabilities dc = new DesiredCapabilities();

        switch (browser) {
            case "chrome":
                dc.setBrowserName("chrome");
                break;

            case "firefox":
                dc.setBrowserName("firefox");
                break;

            default:
                dc.setBrowserName("chrome");
                break;
        }

        URL url = null;
        try {
            url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.set(new RemoteWebDriver(url,dc));

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        return driver.get();
    }

}

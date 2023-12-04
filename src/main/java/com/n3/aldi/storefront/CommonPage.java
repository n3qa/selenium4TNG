package com.n3.aldi.storefront;


import com.n3.aldi.tool.selenium.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage extends BaseTest {
    protected WebDriver driver;
    protected Logger log;

    public CommonPage(WebDriver driver,Logger log){
        this.driver = driver;
        this.log = log;
    }

    //1. STARTING WITH MAIN SUPPORT METHODS
    public void waitForLoad() {
        log.info("The user is awaiting the page to be fully loaded");
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(pageLoadCondition);
        log.info("CONFIRM: The page is fully loaded. Document ready state is complete.");
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    public void waitFor(By locator, Duration timeOut) {

        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    /**
     * <b>Wait for element to be visible</b>
     * <p>
     * <b>Provide an &lt;Locator finding strategy; in the method </b><br>
     * <b>In result the webdriver will try to find the web element with the specific locator:</b><br>
     * </p>
     *
     * @param locator the web element locator strategy text
     */
    public void waitForVisibilityOf(By locator, Duration timeOut) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement elm = driver.findElement(locator);
                timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
                WebDriverWait wait = new WebDriverWait(driver, timeOut);
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

                break;
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }
    }

    /**
     * <b>Wait for element to be visible</b>
     * <p>
     * <b>Provide an &lt;Locator finding strategy; in the method </b><br>
     * <b>In result the webdriver will try to find the web element with the specific locator:</b><br>
     * </p>
     *
     * @param locator the web element locator strategy text
     */
    public void waitForPresenceOfOf(By locator, Duration timeOut) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement elm = driver.findElement(locator);
                timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
                WebDriverWait wait = new WebDriverWait(driver, timeOut);
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                break;
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }
    }

    public void waitForElementToBeClickable(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement elm = driver.findElement(locator);
                Duration timeOut = Duration.ofSeconds(30);
                WebDriverWait wait = new WebDriverWait(driver, timeOut);
                wait.until(ExpectedConditions.elementToBeClickable(locator));

                break;
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                log.info("Waiting to be clickable a web-element with properties: "+element);
                Duration timeOut =  Duration.ofSeconds(30);
                WebDriverWait wait = new WebDriverWait(driver, timeOut);
                wait.until(ExpectedConditions.elementToBeClickable(element));

                break;
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }
    }

    /**
     * <b>For dev reusage  find by element Selenium native method</b>
     * <p>
     * <b>Provide an &lt;Locator finding strategy; in the method </b><br>
     * <b>In result the webdriver will try to find the web element with the specific locator:</b><br>
     * </p>
     *
     * @param locator article name
     */
    public WebElement find (By locator) {
        return driver.findElement(locator);
    }

    public void scrollIntoViewForWebElement(By locator) {
        log.info("# The user is about to scroll toward the webelement in order tobe visible ");
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        log.info("CONFIRM: The use has scrolled into view for webElement: ");

    }


    //2. PROVIDING NAVIGATION
    /**
     * <b>The user navigates to Lidl storefront</b>
     * <p>
     */
    public void navigateToStoreFront(){
        log.info("The user navigates to the Lidl storefront");
        driver.get("https://www.aldi-nord.de");
        waitForLoad();
    }

    /**
     * <b>The user navigates to specific URL</b>
     * <p>
     * <b>Provide an &lt;URLt; in the method </b><br>
     * <b>In result the browser will navigate to the chosen web page:</b><br>
     * </p>
     *
     * @param url article name
     */
    public void navigateToURL(String url ) {
        String providedURL = url; //for debugging when a MAVEN configuration for CI/CD provider will be set
        log.info("The user navigates to URL: "+ providedURL);
        driver.get(providedURL);
        waitForLoad();
    }

    /** Get URL of current page from browser */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    //3. PROVIDING MAIN USER ACTIONS
    /** Click on element with given locator when its visible */
    public void clickOn(By locator) {
        String locatorName = locator.toString();
        log.info(String.format("# The user is about to click  on webElement:   %s .",  locatorName));

        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        log.info(String.format("The user is waiting the webElement: %s to be presented .", locatorName));

        find(locator).click();
        log.info(String.format("CONFIRM: The user has clicked on webElement : %s  .", locatorName));

    }

    /** Type given text into element with given locator */
    public void type(String text, By locator) {
        String locatorName = locator.toString();
        log.info(String.format("# The user is about to provide text: %s  in the input field  %s .", text, locatorName));

        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        log.info(String.format("The user is waiting the input field: %s to be presented .", locatorName));

        find(locator).sendKeys(text);
        log.info(String.format("CONFIRM: The user has provided text: %s  in the input field  %s .", text, locatorName));
    }

}

package com.n3.aldi.storefront.cookies;



import com.n3.aldi.storefront.CommonPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.time.Duration;

public class CookiesPage extends CommonPage {

    private By  cookiesMainDiv = By.id("usercentrics-root");
    private By acceptAllcs = By.cssSelector("button[data-testid=uc-accept-all-button]");
    private By rejectAllcs = By.cssSelector("//button[contains(@data-testid,'uc-deny-all-button')]");
    private By saveCookiesSettings = By.cssSelector("button[id='uc-save-button']");
    private By marketingAndPersonalization = By.cssSelector("button[id='uc-toggle-custom-category-1e2318eb-e762-4850-b0df-438a67507d0d']");
    private By marketing = By.cssSelector("button[id='uc-toggle-marketing']");


    public CookiesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void acceptAllCookieSettings() {
         log.info("# The user is about to click on accept all cookie settings.");
         log.info("The user is waiting the fast decision cookie settings window to appear");
           waitForPresenceOfOf(cookiesMainDiv, Duration.ofSeconds(10));
            try {
                log.info("# The user is about to click  on accept all cookie settings");
                // private By  cookiesMainDiv = By.id("usercentrics-root");
                SearchContext  shadowRoot = driver.findElement(cookiesMainDiv).getShadowRoot();
                WebElement acceptAllCookies = shadowRoot.findElement(By.cssSelector("button[data-testid=uc-accept-all-button]"));

                waitForElementToBeClickable(acceptAllCookies);
                acceptAllCookies.click();
                log.info("CONFIRM: The user has clicked on accept all cookies settings button");
            } catch (NoSuchElementException e) {
                log.error("The user was not able to click on accept all cookies settings button");
                throw new RuntimeException(e);
            }
        }

    public void clickOnCookiesSettingsFor(String option) {
        log.info("The user is waiting the fast decision cookie settings window to appear");
        waitForPresenceOfOf(cookiesMainDiv, Duration.ofSeconds(10));
        try {
            log.info(String.format("# The user is about to click on cookie option for:  %s",  option));
            SearchContext  shadowRoot = driver.findElement(cookiesMainDiv).getShadowRoot();

            //Constructing dynamic locator for the different cookie settings buttons
            String cssLocator = String.format("button[data-testid=uc-%s",  option);
            WebElement cookieSettingsButton = shadowRoot.findElement(By.cssSelector(cssLocator));

            cookieSettingsButton.click();
            log.info(String.format("CONFIRM The user has clicked on cookie option for:  %s",  option));
        } catch (NoSuchElementException e) {
            log.error(String.format("ERROR The user was not able clicked on cookie option for:  %s",  option));
            throw new RuntimeException(e);
        }
    }

    public void clickOnMarketingCookiesSettings() {
        String option = "Marketing";
        log.info("The user is waiting the fast decision cookie settings window to appear");
        waitForPresenceOfOf(cookiesMainDiv, Duration.ofSeconds(10));
        try {
            log.info(String.format("# The user is about to click on cookie option for:  %s",  option));
            SearchContext  shadowRoot = driver.findElement(cookiesMainDiv).getShadowRoot();

            //Constructing dynamic locator for the different cookie settings buttons
            String cssLocator = String.format("button[data-testid=uc-%s",  option);
            WebElement cookieSettingsButton = shadowRoot.findElement(By.cssSelector(cssLocator));

            cookieSettingsButton.click();
            log.info(String.format("CONFIRM The user has clicked on cookie option for:  %s",  option));
        } catch (NoSuchElementException e) {
            log.error(String.format("ERROR The user was not able clicked on cookie option for:  %s",  option));
            throw new RuntimeException(e);
        }
    }
}

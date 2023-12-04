package com.n3.aldi.storefront.cookies;



import com.n3.aldi.storefront.CommonPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.time.Duration;

public class CookiesPage extends CommonPage {

    private By  cookiesMainDiv = By.id("usercentrics-root");
    private By acceptAllcs = By.xpath("//button[contains(@data-testid,'uc-accept-all-button')]");
    public CookiesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void acceptAllCookieSettings() {
         log.info("# The user is about to click on accept all cookie settings.");
         log.info("The user is waiting the fast decision cookie settings window to appear");
           waitForPresenceOfOf(cookiesMainDiv, Duration.ofSeconds(10));
            try {
                log.info("# The user is about to click  on accept all cookie settings");

                SearchContext  shadowRoot = driver.findElement(cookiesMainDiv).getShadowRoot();
                WebElement acceptAllCookies = shadowRoot.findElement(By.xpath("//button[contains(@data-testid,'uc-accept-all-button')]"));

                acceptAllCookies.click();
                log.info("CONFIRM: The user has clicked on accept all cookies settings button");
            } catch (NoSuchElementException e) {
                log.error("The user was not able to click on accept all cookies settings button");
                throw new RuntimeException(e);
            }
        }
}

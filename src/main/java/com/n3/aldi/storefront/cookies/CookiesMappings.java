package com.n3.aldi.storefront.cookies;

import com.n3.aldi.storefront.CommonPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CookiesMappings extends CommonPage {

  /**
   * <b> Locators </b>
   * <p>
   * <b> &lt;One trust UI &gt; </b><br>
   * <b>Fast decision window/pop-up</b><br>
   */
//    protected  By metaTitle = By.xpath("//title");
//    protected By logoImageStartPage = By.xpath("//a[@class="brand__link"]//img");
//    protected By  oneTrustContainer = By.xpath("//div[contains(@id,"onetrust-banner-sdk")]");
//    public By acceptAllcs = By.xpath("//button[contains(@id,"onetrust-accept-btn-handler")]");
    protected static final String rejectAll_cs =  "";
    protected static final String advanced_cs =  "";

    /*
    *Advance (more) cookie settings
     */
    protected static final String acceptAdvance_cs =  "";
    protected static final String  preferences_cs =   "";
    protected static final String statistics_cs =   "";
    protected static final String marketing_cs =   "";
    protected static final String  submitMoreCS =   "";


  public CookiesMappings(WebDriver driver, Logger log) {
    super(driver, log);
  }



}


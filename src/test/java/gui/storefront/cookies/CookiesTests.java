package gui.storefront.cookies;

import com.n3.aldi.storefront.cookies.CookiesPage;
import com.n3.aldi.storefront.searchresultspage.SearchResultsPage;
import com.n3.aldi.tool.selenium.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTests  extends TestUtilities {

    @Test(description =
            " DE - NORD - 1 - | Cookies | Accept all CS | " +
            " Verify search results page is presented when a " +
            " valid search term is used with combination of " +
            " Accept all cookies settings"
                )
    public void verifySRPisPresentedWithAcceptAllCS() throws InterruptedException {
        log.info(" SK - PROD - 1 - | Cookies | Accept all | " +
                " Verify search results page is presented when a " +
                " valid search term is used with combination of " +
                " Accept all cookies settings");

        String homePageURL = "https://www.aldi-nord.de/";
        String searchTerm = "*";

        CookiesPage cookies = new CookiesPage(driver,log);
        SearchResultsPage srp = new SearchResultsPage(driver,log);

        //Step 1: Navigate to the Lidl Storefront home page
        log.info("*** STEP 1 : The user navigates to Lidl storefront home page");
        cookies.navigateToStoreFront();

        log.info("-> Validate the user loaded the correct page URL");
        String currentPageURL = cookies.getCurrentUrl();
        Assert.assertEquals(currentPageURL,homePageURL);
        log.info("CONFIRM: The user has loaded the correct page.");

        //STEP 2:
        //CLick on Accept all cookies oneTrust cookie settings button
        log.info("*** STEP 2: CLick on oneTrust accept all cookies settings button");
        cookies.acceptAllCookieSettings();

        Thread.sleep(4444);

    }

    @Test(description =
            " DE - NORD - 2 - | Cookies | Reject all CS | " +
                    " Verify search results page is presented when a " +
                    " valid search term is used with combination of " +
                    " Accept all cookies settings"
    )
    public void verifySRPisPresentedWithRejectAllCS() throws InterruptedException {
        log.info(" SK - PROD - 1 - | Cookies | Accept all | " +
                " Verify search results page is presented when a " +
                " valid search term is used with combination of " +
                " Accept all cookies settings");

        String homePageURL = "https://www.aldi-nord.de/";
        String searchTerm = "*";

        CookiesPage cookies = new CookiesPage(driver,log);
        SearchResultsPage srp = new SearchResultsPage(driver,log);

        //Step 1: Navigate to the Lidl Storefront home page
        log.info("*** STEP 1 : The user navigates to Lidl storefront home page");
        cookies.navigateToStoreFront();

        log.info("-> Validate the user loaded the correct page URL");
        String currentPageURL = cookies.getCurrentUrl();
        Assert.assertEquals(currentPageURL,homePageURL);
        log.info("CONFIRM: The user has loaded the correct page.");

        //STEP 2:
        //CLick on Accept all cookies oneTrust cookie settings button
        log.info("*** STEP 2: CLick on oneTrust accept all cookies settings button");
        cookies.clickOnCookiesSettingsFor("deny-all-button");

        Thread.sleep(4444);

    }
}

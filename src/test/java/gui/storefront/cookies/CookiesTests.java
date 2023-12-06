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
        log.info( " DE - NORD - 1 - | Cookies | Accept all CS | " +
                        " Verify search results page is presented when a " +
                        " valid search term is used with combination of " +
                        " Accept all cookies settings");

        String homePageURL = "https://www.aldi-onlineshop.de/";
        String searchTerm = "*";

        CookiesPage cookies = new CookiesPage(driver,log);
        SearchResultsPage srp = new SearchResultsPage(driver,log);

        //Step 1: Navigate to the ALDI Storefront home page
        log.info("*** STEP 1 : The user navigates to ALDI storefront home page");
        cookies.navigateToStoreFront();

        log.info("-> Validate the user loaded the correct page URL");
        String currentPageURL = cookies.getCurrentUrl();
        Assert.assertEquals(currentPageURL,homePageURL);
        log.info("CONFIRM: The user has loaded the correct page.");

        //STEP 2:
        //CLick on Accept all cookies oneTrust cookie settings button
        log.info("*** STEP 2: CLick on accept all cookies settings button");
        cookies.acceptAllCookieSettings();


    }

    @Test(description =
            " DE - NORD - 2 - | Cookies | Marketing CS | " +
                    " Verify search results page is presented when a " +
                    " valid search term is used with combination of " +
                    " Marketing cookies settings"
    )
    public void verifySRPisPresentedWithMarketingCookieSettings() throws InterruptedException {
        log.info( " DE - NORD - 2 - | Cookies | Marketing CS | " +
                " Verify search results page is presented when a " +
                " valid search term is used with combination of " +
                " Marketing cookies settings");

        //Basic flow params
        String homePageURL = "https://www.aldi-onlineshop.de/";
        String marketingCookieSettings = "toggle-marketing";
        //Navigation search bars params
        String navSearchBarPlaceHolder = "Angebote und Produkte finden";
        String searchTerm = "*";

        CookiesPage cookies = new CookiesPage(driver,log);
        SearchResultsPage srp = new SearchResultsPage(driver,log);

        //Step 1: Navigate to the ALDI Storefront home page
        log.info("*** STEP 1 : The user navigates to ALDI storefront home page");
        cookies.navigateToStoreFront();

        log.info("-> Validate the user loaded the correct page URL");
        String currentPageURL = cookies.getCurrentUrl();
        Assert.assertEquals(currentPageURL,homePageURL);
        log.info("CONFIRM: The user has loaded the correct page.");

        //STEP 2:
        //CLick on Accept all cookies oneTrust cookie settings button
        log.info("*** STEP 2: CLick on marketing cookies settings button");
        cookies.clickOnCookiesSettingsFor(marketingCookieSettings);

        //STEP 3:
        // The user confirm the selected cookie setting by clicking on save cookie settings button
        log.info("*** STEP 3: The user confirm the selected cookie setting by clicking on save cookie settings button");
        cookies.clickOnCookiesSettingsFor("save-button");

        //STEP 4:
        // Validate navigation search bar properties
        String actualNavSearchBarPlaceHolder = srp.getPlaceHolderForNavigationSearchBar();
        Assert.assertEquals(actualNavSearchBarPlaceHolder,navSearchBarPlaceHolder);

    }

    @Test(description =
            "DE - NORD - 3 - | Cookies | Marketing and Personalization CS | " +
                    " Verify search results page is presented when a " +
                    " valid search term is used with combination of " +
                    " Marketing and Personalization cookies settings"
    )
    public void verifySRPisPresentedWithMarketingAndPersonalizationCS() throws InterruptedException {
        log.info("DE - NORD - 3 - | Cookies | Marketing and Personalization CS | " +
                " Verify search results page is presented when a " +
                " valid search term is used with combination of " +
                " Marketing and Personalization cookies settings");

        String homePageURL = "https://www.aldi-onlineshop.de/";
        String marketingAndPersonalizationCS = "toggle-custom-category-1e2318eb-e762-4850-b0df-438a67507d0d";
        String searchTerm = "*";

        CookiesPage cookies = new CookiesPage(driver,log);
        SearchResultsPage srp = new SearchResultsPage(driver,log);

        //Step 1: Navigate to the ALDI Storefront home page
        log.info("*** STEP 1 : The user navigates to ALDI storefront home page");
        cookies.navigateToURL(homePageURL);

        log.info("-> Validate the user loaded the correct page URL");
        String currentPageURL = cookies.getCurrentUrl();
        Assert.assertEquals(currentPageURL,homePageURL);
        log.info("CONFIRM: The user has loaded the correct page.");

        //STEP 2:
        //CLick on Accept all cookies oneTrust cookie settings button
        log.info("*** STEP 2: CLick on reject all cookies settings button");
        cookies.clickOnCookiesSettingsFor(marketingAndPersonalizationCS);

        //STEP 3:
        // The user confirm the selected cookie setting by clicking on save cookie settings button
        log.info("*** STEP 3: The user confirm the selected cookie setting by clicking on save cookie settings button");
        cookies.clickOnCookiesSettingsFor("save-button");

    }
}

package com.n3.aldi.storefront.searchresultspage;

import com.n3.aldi.storefront.CommonPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends CommonPage {

   //Locators
   //Main strategy: from TOP of the PAGE to the BOTTOM
   //Second employed strategy : lef aside /facets/

   //Search ResultsPage header
   private By searchResultsPageHeader = By.cssSelector("H1");

   //Navigation search bar
   private By searchBar = By.xpath("//div[contains(@id,'search-input-hook')]");
   private By searchInputField = By.xpath("//input[contains(@id,'s-search-input-field')]"); // Abb = SIF
   private By searchSubmitButton = By.xpath("//button[contains(@data-id,'search-input-button')]");
    //Search input field = abbreaviation -> SIF


    /**
     * <b>General method for interacting with the filters </b>
     * <p>
     * <b>Provide a &lt;Locator  with Xpath finding strategy; in the method </b><br>
     * <b>In result the webdriver will try to find the web element with the specific locator:</b><br>
     * </p>
     *
     * @param facetName article name
     * @return ready for use web Element
     */
    private By filterHeaderButtonFor(String facetName) {
        return  By.xpath((String.format("//button[contains(@data-testselector,'%s-facet')]", facetName)));
    }
//    private By facet_category = By.xpath("//button[contains(@data-testselector,'price-facet')]");
//   private By facet_price = By.xpath("");
//   private By facet_brand = By.xpath("");
//   private By facet_color = By.xpath("");
//   private By facet_size = By.xpath("");
//   private By facet_ratings = By.xpath("");
//   private By facet_ratingsG =By.xpath("");
//   private By load_more_grids_button = By.xpath("");
    public SearchResultsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void submitAbasicSearch(String searchTerm){
        log.info("# The user is about to submit a basic search with single search term");
        //Step 1 : Wait a bit the search input field to be visible/active
        log.info("-> VALIDATE: Navigation search bar is presented to the user");
//        waitForVisibilityOf(searchInputField);

        //Step 2 : Clear the search input field before providing a single search term
//        find(searchInputField).clear();
        log.info("# The user has cleared the navigation search input field");

        //Step 3 : Provide a search term
//        type(searchTerm,searchInputField);

        //Step 4 : Submit the search operation by clicking on UI element search submit button
        log.info("# The user is about to click on search submit button");
//        clickOn(searchSubmitButton);
    }

    public void clickOnFilter(String filterName){
        //1 Wait the facet to be presented

        clickOn(filterHeaderButtonFor(filterName));
    }

}

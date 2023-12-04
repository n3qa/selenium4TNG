package gui.storefront.check;

import com.n3.aldi.storefront.cookies.CookiesPage;
import com.n3.aldi.tool.selenium.base.TestUtilities;
import org.testng.annotations.Test;

public class CheckTest extends TestUtilities {
    @Test
    public  void  navigateToHomePage() throws InterruptedException {
        log.info("Basic check for debugging test cases when build ");
        CookiesPage cookies = new CookiesPage(driver,log);
        cookies.navigateToStoreFront();
        cookies.waitForLoad();

        cookies.acceptAllCookieSettings();

    }
}

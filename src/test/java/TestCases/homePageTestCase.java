package TestCases;

import Pages.homePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

public class homePageTestCase {
    private BaseTest baseTest = new BaseTest();

    @Test
    public void clickNextButton() throws URISyntaxException {
        baseTest.startAndroidApp(); // Initialize the driver and start the app
        homePage homePage = new homePage(BaseTest.driver); // Pass the initialized driver to homePage
        homePage.clickNextButton(); // Interact with the next button
    }

    @AfterEach
    public void tearDown() {
        baseTest.tearDown(); // Quit the driver after the test
    }
}

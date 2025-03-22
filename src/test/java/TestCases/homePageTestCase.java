package TestCases;

import Pages.homePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

public class homePageTestCase extends BaseTest {

    @Test
    public void clickNextButton() throws URISyntaxException {
        homePage.clickNextButton();

    }


}

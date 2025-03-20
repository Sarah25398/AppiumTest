package TestCases;

import Pages.homePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {

    public static AndroidDriver driver; // Static to be shared across tests
    protected homePage homePage;

    @BeforeEach
    public void startAndroidApp() throws URISyntaxException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.studiobluelime.ecommerceapp");
        capabilities.setCapability("appActivity", "com.studiobluelime.ecommerceapp.WelcomeActivity");

        try {
            // Initialize the AndroidDriver
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Initialize the homePage object with the driver
        homePage = new homePage(driver);
    }

    public void waitForElementToBeVisible(String xpath) {
        FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(xpath)));
    }

    public void clickAndroidElementByXpath(String xpath) {
        this.waitForElementToBeVisible(xpath);
        driver.findElement(AppiumBy.xpath(xpath)).click();
    }

    public void assertElementText(String xpath, String content) {
        this.waitForElementToBeVisible(xpath);
        var actualString = driver.findElement(AppiumBy.xpath(xpath)).getText();
        Assert.assertEquals(actualString, content);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

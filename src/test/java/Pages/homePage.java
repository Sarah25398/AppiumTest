package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.studiobluelime.ecommerceapp:id/btn_next']")
    private WebElement nextButton;

    public homePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}

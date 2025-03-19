package Android;

import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class ClothingPage {
    BaseCommand.commonPageAndroid command = new BaseCommand.commonPageAndroid();


    @Test
    public void ClothingPageClick() throws URISyntaxException, InterruptedException {

        new goToHomePage().verifyGoToHomePageByNext();
        var el = "//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\"Clothing\"]";
        command.waitForElementToBeVisible(el);
        command.clickAndroidElementByXpath(el);
        Thread.sleep(3000);
        String[] ClothingItems = {"Kids", "Men", "Women"};
        for (String ClothingItem : ClothingItems) {
            var ClothingChoiceEl = "//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\"" + ClothingItem + "\"]\n";
            command.waitForElementToBeVisible(ClothingChoiceEl);
            command.assertElementText(ClothingChoiceEl, ClothingItem);
        }
    }
    @Test
    public void MenPageClick() throws URISyntaxException, InterruptedException {

        ClothingPageClick();
        var MenElement ="//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\"Men\"]";
        command.waitForElementToBeVisible(MenElement);
        command.clickAndroidElementByXpath(MenElement);



    }
}


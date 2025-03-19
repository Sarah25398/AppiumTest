package Android;

import BaseCommand.commonPageAndroid;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class goToHomePage extends commonPageAndroid {
    @Test
    public void verifyGoToHomePageByNext() throws URISyntaxException, InterruptedException {
        commonPageAndroid command = new commonPageAndroid();
        command.startAndroidApp();
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_next\"]\n");
        Thread.sleep(3000);
        command.assertElementText("//android.widget.TextView[@text=\"eCommerce App\"]\n", "eCommerce App");
    }
    @Test
    public void VerifyHomePageItems() throws URISyntaxException, InterruptedException {
        commonPageAndroid command = new commonPageAndroid();
        verifyGoToHomePageByNext();
        Thread.sleep(3000);
        String[] ItemsClicks = {"Clothing","Groceries"};
        for(String ItemsClick : ItemsClicks){
            var element = "//android.widget.TextView[@resource-id=\"com.studiobluelime.ecommerceapp:id/tv_android\" and @text=\""+ItemsClick+"\"]\n";
            command.waitForElementToBeVisible(element);
            command.assertElementText(element,ItemsClick);
        }

    }



        @Test
    public void verifyGoToHomePageBySkip() throws URISyntaxException {
        commonPageAndroid command = new commonPageAndroid();
        command.startAndroidApp();
        command.clickAndroidElementByXpath("//android.widget.Button[@resource-id=\"com.studiobluelime.ecommerceapp:id/btn_skip\"]\n");
        command.assertElementText("//android.widget.TextView[@text=\"eCommerce App\"]\n", "eCommerce App");
    }
}
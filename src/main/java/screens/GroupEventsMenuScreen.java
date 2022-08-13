package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GroupEventsMenuScreen extends BaseScreen{
    public GroupEventsMenuScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/grouped_list_toolbar']")
    MobileElement toolbarGroups;
    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    MobileElement returnBtn;

    public GroupEventsMenuScreen checkGroupToolbarPresentAssert(){
        should(toolbarGroups,5);
        Assert.assertTrue(toolbarGroups.isDisplayed());
        return this;
    }
    public HomeScreen returnToEvents(){
        returnBtn.click();
        return new HomeScreen(driver);
    }
}

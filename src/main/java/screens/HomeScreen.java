package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreen  extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logOutBtn;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;


    public EditCreatEventScreen initCreationEvent(){
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreatEventScreen(driver);
    }
    public boolean ifFabAddPresent(){
        // check if + appears
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }
    public HomeScreen openMenu(){
        if(isDisplayedWithExp(burgerMenu)) {
            burgerMenu.click();
        }
        return this;
    }

    public LoginScreen logOut(){
        if(isDisplayedWithExp(logOutBtn)) {
            logOutBtn.click();
        }
        return new LoginScreen(driver);
    }
    public HomeScreen checkFabBtnPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }



}

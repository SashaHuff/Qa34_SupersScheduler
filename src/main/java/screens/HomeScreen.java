package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomeScreen  extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@content-desc='Open']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_container_main']")
    MobileElement event;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logOutBtn;
    @FindBy (xpath = "//[text()='You don't have events']")
    MobileElement toastMSG;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/group_events_menu']")
    MobileElement groupEvents;
/*
check from list of events
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_container_main']")
    List<MobileElement> listEvents;

    public EditCreatEventScreen selectFirstEvent(){
        pause(2000);
        listEvents.get(0).click();

        return new EditCreatEventScreen(driver);

    }

 */




    public EditCreatEventScreen initCreationEvent(){
        should(fabAdd,5);
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreatEventScreen(driver);
    }
    public boolean ifFabAddPresent(){
        // check if + appears
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }
    public HomeScreen openMenu2(){
        if(isElementPresent(By.xpath("//*[@content-desc='Open']"))) {
            burgerMenu.click();
        }
        return this;
    }

    public HomeScreen openMenu3(){
        if(list.size()>0) {
            list.get(0).click();
        }
        return this;
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
    /*
    this method does't work now
    public boolean toastMsgAppearance(){
        should(groupEvents,2);
        groupEvents.click();
        return isElementPresent(By.xpath("//*[text()='You don't have events')]"));
    }

     */
    public GroupEventsMenuScreen clickOnMenuEvents(){
        should(groupEvents,5);
        groupEvents.click();
        return new GroupEventsMenuScreen(driver);
    }

    public EditCreatEventScreen clickOnEvent(){
            should(event,5);
            event.click();
            return new EditCreatEventScreen(driver);
    }


}

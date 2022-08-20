package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void type(MobileElement el, String text){
        if (text != null){
            el.click();
            el.clear();
            el.sendKeys(text);
        }
    }
    public void shoulHave(MobileElement el,String text, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.textToBePresentInElement(el,text));

    }
    public void should(MobileElement el, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(el));
    }
    public boolean isDisplayedWithExp(MobileElement element){
        try {
            should(element, 5);
            return element.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void pause (int time){


        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WizardScreen extends BaseScreen{
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipBtn;

    public HomeScreen skipWizard(){
        should(skipBtn,10);
        skipBtn.click();

        return new HomeScreen(driver);
    }
}

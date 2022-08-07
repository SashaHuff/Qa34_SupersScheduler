package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginBtn;

    public LoginScreen fillEmail(String email){
        should(emailEditText,10);
        type(emailEditText,email);
        return this;
     //   return new LoginScreen(driver);
    }
    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }
    public HomeScreen clickBtnLogin(){
        driver.hideKeyboard();
        loginBtn.click();
        return new HomeScreen(driver);
    }

}

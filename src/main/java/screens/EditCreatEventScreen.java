package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EditCreatEventScreen extends BaseScreen{
    public EditCreatEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusBtn;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/delete_menu']")
    MobileElement deleteBtn;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;
    //com.example.svetlana.scheduler:id/row_month_txt
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")
    List<MobileElement> months;

    public HomeScreen createNewEvent(Event event){
        should(title,5);
        type(title, event.getTitle());
        type(type, event.getType());
        driver.hideKeyboard();

        int breaks= event.getBreaks();
        if(breaks>0 && breaks<5){
            for (int i = 0; i < breaks; i++) {
                breakPlusBtn.click();
            }
        }

        wageEdit.click();

        type(wageInput,String.valueOf(event.getWage()));
        wageSave.click();
        confirmCreation.click();

        return new HomeScreen(driver);
    }
    public HomeScreen deleteEvent(){
        should(deleteBtn,5);
        deleteBtn.click();
        return new HomeScreen(driver);
    }
    public EditCreatEventScreen dataAction(){
        pause(3000);
        //Actions actions = new Actions(wd);
        MobileElement elementDay = days.get(2);
        Rectangle rect = elementDay.getRect();

        int xFrom= rect.getX() + rect.getWidth()/2;
        int xTo = driver.manage().window().getSize().getWidth()/2;
        int y = rect.getY()+ rect.getHeight()/2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release().perform();

        return this;
    }
    public EditCreatEventScreen selectDataAction(String data){  //"18/08/2022" ==== LocalDate inputdata
        //15 +AUGUST  ==== LocalDate current
        pause(3000);
        LocalDate inputData=LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate  current=getLocalDate(days.get(0).getText(),months.get(0).getText());
        while (!inputData.equals(current)) {
            dataAction();
            pause(1000);
            current =getLocalDate(days.get(0).getText(),months.get(0).getText());

        }

        return this;
    }

    private LocalDate getLocalDate(String day, String month) {  //"15/AUGUST
// AUGUST == August
        month=month.toLowerCase(); //august
        month =month.substring(0,1).toUpperCase()+month.substring(1).toLowerCase();



        String data = day+"/"+month+"/"+"2022";    //   "15/August/2022"
        LocalDate a=LocalDate.parse(data, DateTimeFormatter.ofPattern("d/MMMM/yyyy"));
        return a;
    }


}
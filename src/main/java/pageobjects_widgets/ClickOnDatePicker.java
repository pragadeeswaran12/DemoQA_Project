package pageobjects_widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnDatePicker {
    
    WebDriver driver;

    // Using @FindBy annotations for locating elements
    @FindBy(id = "datePickerMonthYearInput")
    WebElement Txt_DOB;
    
    @FindBy(id = "dateAndTimePickerInput")
    WebElement Txt_DateAndTime;

    // Constructor to initialize the PageFactory elements
    public ClickOnDatePicker(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize the PageFactory
    }

    // Method to perform actions on date and time pickers
    public String ClickDataPicker(String Date, String DateAndTime) throws Exception {
        // Interact with the date picker input field
        Txt_DOB.click();
        Txt_DOB.sendKeys(Keys.CONTROL + "a");
        Txt_DOB.sendKeys(Date);
        Txt_DOB.sendKeys(Keys.ENTER);

        // Interact with the date and time picker input field
        Txt_DateAndTime.click();
        Txt_DateAndTime.sendKeys(Keys.CONTROL + "a");
        Txt_DateAndTime.sendKeys(DateAndTime);
        Txt_DateAndTime.sendKeys(Keys.ENTER);
        
        return driver.getTitle();
    }
}

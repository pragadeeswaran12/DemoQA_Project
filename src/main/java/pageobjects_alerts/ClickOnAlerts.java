package pageobjects_alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnAlerts {

    WebDriver driver;

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement btn_SeeAlert;
    
    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement btn_After5SecAlert;

    @FindBy(id = "confirmButton")
    private WebElement btn_ConfirmBox;
    
    @FindBy(id = "promtButton")
    private WebElement btn_PromtBox;

    // Constructor
    public ClickOnAlerts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize Page Factory
    }

    // Method to click alert button and accept the alert
    public String clickAlerts() throws InterruptedException {
        btn_SeeAlert.click();
        driver.switchTo().alert().accept();
        
        btn_After5SecAlert.click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        
        btn_ConfirmBox.click();
        driver.switchTo().alert().accept();
        
        btn_PromtBox.click();
     // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Send value to the prompt alert
        alert.sendKeys("pragadees");

        // Accept the alert (click OK button)
        alert.accept();
        
        return driver.getTitle();
    }
}
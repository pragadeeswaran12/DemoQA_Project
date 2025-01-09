package pageobjects_alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnModalDialogs {

    WebDriver driver;

    @FindBy(id = "showSmallModal")
    private WebElement btnSmallModal;

    @FindBy(id = "closeSmallModal")
    private WebElement btnCloseSmall;

    @FindBy(id = "showLargeModal")
    private WebElement btnLargeModal;

    @FindBy(id = "closeLargeModal")
    private WebElement btnCloseLarge;

    // Constructor to initialize Page Factory
    public ClickOnModalDialogs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to handle modal dialogs
    public String clickModalDialogs() {
        btnSmallModal.click();
        btnCloseSmall.click();
        btnLargeModal.click();
        btnCloseLarge.click();
        
        return driver.getTitle();
    }
}

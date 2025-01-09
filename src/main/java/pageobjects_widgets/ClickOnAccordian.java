package pageobjects_widgets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnAccordian {

    WebDriver driver;

    @FindBy(id = "section2Heading")
    private WebElement btnComeFrom;

    // Constructor to initialize Page Factory
    public ClickOnAccordian(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the accordion
    public String clickAccordian() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnComeFrom);
        btnComeFrom.click();
        return driver.getTitle();
    }
}

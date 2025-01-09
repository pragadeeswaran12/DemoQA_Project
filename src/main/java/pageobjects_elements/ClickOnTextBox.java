package pageobjects_elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnTextBox 
{
    WebDriver driver;

    // Define web elements using @FindBy annotation
    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement btn_TextBox;

    @FindBy(id = "userName")
    WebElement txt_FullName;

    @FindBy(id = "userEmail")
    WebElement txt_Email;

    @FindBy(id = "currentAddress")
    WebElement txt_CurrentAddress;

    @FindBy(id = "permanentAddress")
    WebElement txt_PermanentAddress;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btn_Submit;

    // Constructor to initialize elements
    public ClickOnTextBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String fillTextboxAndVerifyDetails(String fullName, String email, String currentAddress, String permanentAddress) {
        try {
            // Click the Text Box button
            btn_TextBox.click();

            // Enter the details in the respective fields
            txt_FullName.sendKeys(fullName);
            txt_Email.sendKeys(email);
            txt_CurrentAddress.sendKeys(currentAddress);
            txt_PermanentAddress.sendKeys(permanentAddress);

            // Retrieve and validate entered details
            String enteredFullName = txt_FullName.getAttribute("value");
            String enteredEmail = txt_Email.getAttribute("value");
            String enteredCurrentAddress = txt_CurrentAddress.getAttribute("value");
            String enteredPermanentAddress = txt_PermanentAddress.getAttribute("value");

            // Print values for debugging
            System.out.println("Entered Full Name: " + enteredFullName);
            System.out.println("Entered Email: " + enteredEmail);
            System.out.println("Entered Current Address: " + enteredCurrentAddress);
            System.out.println("Entered Permanent Address: " + enteredPermanentAddress);

            // Validation logic
            if (enteredFullName.equals(fullName) &&
                enteredEmail.equals(email) &&
                enteredCurrentAddress.equals(currentAddress) &&
                enteredPermanentAddress.equals(permanentAddress)) {
                System.out.println("TextBox All details were entered correctly.");
            } else {
                System.out.println("TextBox Some details were not entered correctly.");
            }

            // Submit the form
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", btn_Submit);
            btn_Submit.click();

            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
		return null;
    }
}

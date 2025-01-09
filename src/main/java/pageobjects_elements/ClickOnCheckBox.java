package pageobjects_elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnCheckBox 
{
	WebDriver driver;
	// Define web elements using @FindBy annotation
    @FindBy(xpath = "//button[@title='Expand all']")
    WebElement btn_Plus;

    @FindBy(xpath = "//button[@title='Collapse all']")
    WebElement btn_Minus;

    @FindBy(xpath = "//span[@class='rct-title']")
    List<WebElement> list_Checkboxes;

    @FindBy(xpath = "//span[@class='text-success']")
    WebElement txt_SelectCheckboxValue;

    // Constructor to initialize elements
    public ClickOnCheckBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	
    public String selectAndVerifyCheckBox(String checkBoxValue) {
        try {
            // Expand all checkboxes
        	Thread.sleep(2000);
            btn_Plus.click();

            Thread.sleep(2000);
            // Check if the list of checkboxes is empty
            if (list_Checkboxes.isEmpty()) {
                System.out.println("Checkbox list not found.");
            }

            // Iterate through the list of checkboxes
            boolean isCheckboxFound = false;
            for (WebElement checkbox : list_Checkboxes) {
                // Check if the checkbox text matches the given value
                if (checkbox.getText().trim().equalsIgnoreCase(checkBoxValue)) {
                    // Click the checkbox and set flag
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
                    checkbox.click();
                    isCheckboxFound = true;
                    System.out.println("Successfully clicked on the checkbox: " + checkBoxValue);
                    break;
                }
            }

            // If no matching checkbox is found
            if (!isCheckboxFound) {
                System.out.println("Checkbox with value '" + checkBoxValue + "' not found.");
                return null;
            }

            // Verify the selected checkbox value
            String selectedValue = txt_SelectCheckboxValue.getText();
            if (selectedValue.equalsIgnoreCase(checkBoxValue)) {
                System.out.println("Checkbox selection verified successfully: " + selectedValue);
            } else {
                System.out.println("Checkbox selection verification failed. Expected: " + checkBoxValue + ", but found: " + selectedValue);
            }
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
		return null;
    }

}

package pageobjects_forms;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnteringPracticeFormDetails {
    WebDriver driver;

    // Locating elements using @FindBy annotations
    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement btnPracticeForm;

    @FindBy(id = "firstName")
    WebElement txtFirstName;

    @FindBy(id = "lastName")
    WebElement txtLastName;

    @FindBy(id = "userEmail")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@type='radio'][1]//parent::div")
    WebElement btnGender;

    @FindBy(id = "userNumber")
    WebElement txtMobileNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement txtDOB;

    @FindBy(xpath = "//*[contains(@class, 'react-datepicker__month-select')]")
    WebElement popMonth;

    @FindBy(xpath = "//*[contains(@class, 'react-datepicker__year-select')]")
    WebElement popYear;

    @FindBy(xpath = "//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
    WebElement txtSubjects;

    @FindBy(xpath = "//input[@type='checkbox'][1] //parent::div")
    WebElement chkHobbies;

    @FindBy(xpath = "//*[contains(@class, 'form-file-label')]")
    WebElement btnPicture;

    @FindBy(id = "currentAddress")
    WebElement txtAddress;

    @FindBy(id = "uploadPicture")
    WebElement inputUploadPicture;
    
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btn_sunmit;
    
    @FindBy(xpath = "//button[text()='Close']")
    WebElement btn_close;

    // Constructor to initialize the driver and PageFactory
    public EnteringPracticeFormDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing PageFactory
    }

    // Method to fill the Practice Form
    public String practiceFormDetails(String firstName, String lastName, String email, String gender, String mobileNumber, 
                                    String dob, String subject, String hobbies,String sFilepath, String address, String state, String city) {
        try {
            // Click on Practice Form
            btnPracticeForm.click();

            // Entering the First Name
            txtFirstName.sendKeys(firstName);

            // Entering the Last Name
            txtLastName.sendKeys(lastName);

            // Entering the Email
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", txtEmail);
            txtEmail.sendKeys(email);

            // Clicking the Gender
            js.executeScript("arguments[0].scrollIntoView(true);", btnGender);
            btnGender.click();

            // Entering the Mobile Number
            txtMobileNumber.sendKeys(mobileNumber);

         // Split the date string into day, month, and year
            String[] dobParts = dob.split("-"); // Splitting by "-"
            String day = dobParts[0];          // Extracting day
            String month = dobParts[1];        // Extracting month
            String year = dobParts[2];         // Extracting year
            
            // Selecting Date of Birth
            txtDOB.click();
            Select selectMonth = new Select(popMonth);
            selectMonth.selectByVisibleText(month);

            // Selecting Year
            Select selectYear = new Select(popYear);
            selectYear.selectByVisibleText(year);

            // Selecting Date
            // Locate all the date elements using the generic XPath
            List<WebElement> dates = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div//div"));

            // Iterate through the elements
            for (WebElement date : dates) {
                // Check if the date's text matches the target date
                if (date.getText().equals(day)) {
                    // Click on the matching date
                    date.click();
                    System.out.println("Date " + day + " is selected.");
                    break; // Exit the loop after selecting the desired date
                }
            }

            // If no matching date is found, you may add error handling:
//            if (!dates.stream().anyMatch(e -> e.getText().equals(day))) {
//                System.out.println("Date " + day + " not found.");
//            }

            Thread.sleep(2000);

            // Entering the Subjects
//          js.executeScript("arguments[0].scrollIntoView(true);", txtSubjects);
//          txtSubjects.click();
//          txtSubjects.sendKeys(subject);
            Thread.sleep(2000);

            // Clicking the Hobbies Checkbox
            chkHobbies.click();
            Thread.sleep(2000);

            // Uploading the File
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            wait.until(ExpectedConditions.elementToBeClickable(inputUploadPicture)); 
     
            // Use JavaScriptExecutor to click the element 
            js.executeScript("arguments[0].click();", inputUploadPicture); 
           
            Robot rb =new Robot(); 
            rb.delay(2000); 
             
            StringSelection ss=new  StringSelection(sFilepath); 
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
             
            rb.keyPress(KeyEvent.VK_CONTROL); 
            rb.keyPress(KeyEvent.VK_V); 
                     
            rb.keyRelease(KeyEvent.VK_CONTROL); 
            rb.keyRelease(KeyEvent.VK_V); 
                     
            rb.keyPress(KeyEvent.VK_ENTER); 
            rb.keyRelease(KeyEvent.VK_ENTER); 

            // Entering the Address
            txtAddress.click();
            txtAddress.sendKeys(address);
            
            //Entering State
            WebElement dropdown = driver.findElement(By.id("react-select-3-input")); 
            dropdown.sendKeys(state); // Pass the state name dynamically 
            dropdown.sendKeys(Keys.ENTER);
            
            //Entering State
            WebElement city1 = driver.findElement(By.id("react-select-4-input"));
            city1.sendKeys(city); // Pass the state name dynamically
            city1.sendKeys(Keys.ENTER); 
            
            //Click on Submit
            btn_sunmit.click();
            
            //Click on Close
            btn_close.click();
            
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
		return null;
    }
}

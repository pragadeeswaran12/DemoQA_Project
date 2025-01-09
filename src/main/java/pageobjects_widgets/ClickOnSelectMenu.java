package pageobjects_widgets;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickOnSelectMenu {

	public WebDriver driver;

	// Constructor to initialize the WebDriver
	public ClickOnSelectMenu(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	// Method to select an option from the custom dropdown
	public void SelectValue(String valueToSelect) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// Locate the dropdown container and click to open the options
		WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select Option']"));
		if (dropdown.isDisplayed()) {
			// JavaScript click to open the dropdown
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", dropdown);
			dropdown.click();
		} else {
			System.out.println("the ellement is not found");
		}

		// JavaScript click to open the dropdown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropdown);

		// Locate the option using the value (or text) you want to select and click on
		// it
		WebElement option = driver.findElement(By.xpath("//div[text()='" + valueToSelect + "']"));
		option.click();

		// Optionally, verify that the correct option was selected
		System.out.println("Selected option: " + valueToSelect);
	}

	public void SelectOne(String sValueSelectOne) {
		// Locate the dropdown container and click to open the options

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// Locate the dropdown container and click to open the options
		WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select Title']"));
		if (dropdown.isDisplayed()) {
			// JavaScript click to open the dropdown
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", dropdown);
			dropdown.click();
		} else {
			System.out.println("the ellement is not found");
		}

		// JavaScript click to open the dropdown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropdown);

		// Locate the option using the value (or text) you want to select and click on
		// it
		WebElement option = driver.findElement(By.xpath("//div[text()='" + sValueSelectOne + "']"));
		option.click();

		// Optionally, verify that the correct option was selected
		System.out.println("Selected option: " + sValueSelectOne);

	}

	public void MenuColour(String colorToSelect) {
		try {
			// Wait until the dropdown is present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("oldSelectMenu")));

			// Use the Select class to interact with the dropdown
			Select select = new Select(dropdown);
			select.selectByVisibleText(colorToSelect);

			// Verify the selected option
			String selectedColor = select.getFirstSelectedOption().getText();
			if (selectedColor.equals(colorToSelect)) {
				System.out.println("Successfully selected color: " + selectedColor);
			} else {
				System.out.println("Failed to select the color. Selected: " + selectedColor);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

// Method to select multiple options dynamically 
	public void selectOptions(WebDriver driver, WebElement dropdownInput, List<String> options) {
		// Wait for the dropdown to become visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Select...']")));

		// Click the dropdown to activate it
		dropdown.click();

		// Loop through the provided options and select them one by one
		for (String option : options) {
			try {
				// Send the option text to the input field
				dropdownInput.sendKeys(option);

				// Press 'Enter' to select the option
				dropdownInput.sendKeys(Keys.ENTER);

				System.out.println("Successfully selected: " + option);
			} catch (Exception e) {
				System.out.println("Failed to select option: " + option + " due to: " + e.getMessage());
			}
		}

//    // Optional: Print all currently selected options 
//    try { 
//        List<WebElement> selectedOptions = driver.findElements(By.cssSelector(".css-class-for-selected-options")); // Update selector if necessary 
//        System.out.println("Currently selected options:"); 
//        for (WebElement selectedOption : selectedOptions) { 
//            System.out.println(selectedOption.getText()); 
//        } 
//    } catch (Exception e) { 
//        System.out.println("Failed to fetch selected options: " + e.getMessage()); 
//    } 
	}

	public String Standardmultiselect(String sCar) {

		WebElement dropdown = driver.findElement(By.id("cars"));

		Select select = new Select(dropdown);

		// Select multiple options
		select.selectByVisibleText(sCar);
		return driver.getTitle();
	}
}











//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//public class ClickOnSelectMenu 
//{
//    WebDriver driver;
//
//    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
//    WebElement Pop_Option;
//
//    @FindBy(id = "selectOne")
//    WebElement Pop_Title;
//
//    @FindBy(id = "oldSelectMenu")
//    WebElement Pop_Color;
//
//    @FindBy(xpath = "(//div[@class='css-1g6gooi'])[2]")
//    WebElement Pop_MultipleDrop;
//
//    @FindBy(id = "cars")
//    List<WebElement> Pop_MultiSelect;
//
//    public ClickOnSelectMenu(WebDriver driver)
//    {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);  // Initialize elements using PageFactory
//    }
//
//    public String ClickSelectMenu(String Option, String Title, String Color, String MultipleDropValue1, String MultipleDropValue2) throws InterruptedException
//    {
////        // Selecting the Option
////    	WebElement option = driver.findElement(By.id("withOptGroup"));
////        Select selectOption = new Select(option);
////        selectOption.selectByVisibleText(Option); 
//        
////    	Pop_Option.click();
//    	//Thread.sleep(2000);
//    	Pop_Option.sendKeys(Option);
//    	Pop_Option.sendKeys(Keys.ENTER);
//    	
//        // Selecting the Title
//        WebElement title = driver.findElement(By.id("selectOne"));
//        Select selectTitle = new Select(title);
//        selectTitle.selectByVisibleText(Title);
//
//        // Entering the Color
//        Pop_Color.click();
//        Pop_Color.sendKeys(Color);
//
//        // Selecting the Multiple Dropdown values
//        Select selectMultipleDrop = new Select(Pop_MultipleDrop);
//        selectMultipleDrop.selectByVisibleText(MultipleDropValue1);  
//
//        Actions actions = new Actions(driver);    // Create an instance of the Actions class
//        actions.sendKeys(Keys.ENTER);   // Press the "Enter" key
//        selectMultipleDrop.selectByVisibleText(MultipleDropValue2); 
//        
//        Actions actions1 = new Actions(driver);  // Create another instance of the Actions class
//        actions1.sendKeys(Keys.ENTER);  // Press the "Enter" key
//
//        // Handling multi-select options
//        if (Pop_MultiSelect.isEmpty()) {
//            System.out.println("Multi select values not found");
//        } else {
//            for (WebElement mulSelect : Pop_MultiSelect) {
//                if (mulSelect.getText().trim().equalsIgnoreCase(MultipleDropValue2)) {
//                    mulSelect.click();
//                    System.out.println("Successfully clicked on Multi select value: " + MultipleDropValue2);
//                    break;
//                }
//            }
//        }
//        return driver.getTitle();
//    }
//}

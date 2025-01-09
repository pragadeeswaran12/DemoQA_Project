package BookStoreApplication;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickOnLogin
{
  WebDriver driver;

  @FindBy(id = "userName")
  WebElement Txt_UserName;

  @FindBy(id = "password")
  WebElement Txt_Password;

  @FindBy(xpath = "//button[text()='Login']")
  WebElement btn_Login;

  @FindBy(id = "gotoStore")
  WebElement Btn_GoToBookStore;

  @FindBy(xpath = "//button[text()='Log out']")
  WebElement Btn_Logout;

  // Constructor to initialize the WebElements using PageFactory
  public ClickOnLogin(WebDriver driver)
  {
      this.driver = driver;
      PageFactory.initElements(driver, this);  // Initialize the PageFactory elements
  }

  // The login method
  public String LoginPages(String Username, String Password)
  {
      try {
          // Set an implicit wait (you only need to do this once for the driver)
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          // Wait for the username field to be visible and then input the username
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOf(Txt_UserName)).sendKeys(Username); 

          // Wait for the password field to be visible and then input the password
          wait.until(ExpectedConditions.visibilityOf(Txt_Password)).sendKeys(Password); 

          // Wait for the login button to be visible before clicking
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].scrollIntoView(true);", btn_Login);
          wait.until(ExpectedConditions.elementToBeClickable(btn_Login)).click();

          // Wait for the logout button to be visible before clicking
          js.executeScript("arguments[0].scrollIntoView(true);", Btn_Logout);
          wait.until(ExpectedConditions.elementToBeClickable(Btn_Logout)).click();
      } catch (Exception e) {
          System.out.println("Exceptions Caught: " + e.getMessage());
      }
      return driver.getTitle();
  }
}


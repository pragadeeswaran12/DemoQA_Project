package pageobjects_elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnWebTable {

    WebDriver driver;

    // Page Factory annotations for locating elements
    @FindBy(id = "searchBox")
    private WebElement txtSearch;

    @FindBy(id = "edit-record-1")
    private WebElement btnEdit;

    @FindBy(id = "firstName")
    private WebElement txtFirstName;

    @FindBy(id = "age")
    private WebElement txtAge;

    @FindBy(id = "submit")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[contains(@class, 'rt-td')]")
    private WebElement wtFirstname;

    @FindBy(xpath = "//*[contains(@class, 'rt-td')][3]")
    private WebElement wtAge;

    // Constructor to initialize elements
    public ClickOnWebTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to perform web table actions
    public String WebTables(String searchName, String fname, String age) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", txtSearch);
        txtSearch.click();
        txtSearch.sendKeys(searchName);
        js.executeScript("arguments[0].scrollIntoView(true);", btnEdit);
        btnEdit.click();
        js.executeScript("arguments[0].scrollIntoView(true);", txtFirstName);
        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
        js.executeScript("arguments[0].scrollIntoView(true);", txtAge);
        txtAge.clear();
        txtAge.sendKeys(age);
        js.executeScript("arguments[0].scrollIntoView(true);", btnSubmit);
        btnSubmit.click();
        js.executeScript("arguments[0].scrollIntoView(true);", txtSearch);
        txtSearch.clear();
        txtSearch.sendKeys(fname);

        // Verification
        String actualFirstName = wtFirstname.getText();
        String actualAge = wtAge.getText();

        if (actualFirstName.equals(fname) && actualAge.equals(age)) {
            System.out.println("Firstname and Age successfully updated");
        } else {
            System.out.println("Firstname and Age not successfully updated");
        }
        return driver.getTitle();
    }
}

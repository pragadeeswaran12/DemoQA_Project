package pageobjects_widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClickOnProgressBar {
    private WebDriver driver;
    private WebDriverWait wait;

    public ClickOnProgressBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String handleProgressBar(int targetPercentage) {
        try {
            // Find and click start button
            WebElement startButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start']"))
            );
            startButton.click();

            // Wait and monitor progress
            while (true) {
                try {
                    // Get current progress with a small delay
                    Thread.sleep(500); // Add small delay to let progress update
                    WebElement progressBar = wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='progressbar']"))
                    );
                    String progressText = progressBar.getText().trim();
                    
                    
                    // Only try to parse if we have actual text
                    if (!progressText.isEmpty()) {
                        String progress = progressText.replace("%", "").trim();
                        int currentProgress = Integer.parseInt(progress);

                        if (currentProgress >= targetPercentage) {
                            WebElement stopButton = driver.findElement(By.xpath("//button[text()='Stop']"));
                            stopButton.click();
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    // Continue if we can't parse the number
                    continue;
                }
                return driver.getTitle();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Progress monitoring was interrupted", e);
        }
		return null;
    }
}
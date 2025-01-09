package Testcases;

import org.testng.annotations.Test;
import commonsteps.choosingCategory;
import pageobjects_alerts.ClickOnAlerts;
import pageobjects_alerts.ClickOnBrowserWindows;
import pageobjects_alerts.ClickOnModalDialogs;
import util.baseClass;

public class TC_003_AlertFrameWindows extends baseClass {
	@Test
	public void AlertFrameWindows() throws InterruptedException {
		
		reportGenerator.getAttributes("DemoQA", "AlertFrameWindows", "Pragadees", "TC_003");
		
		reportGenerator.writeStep("Category page","User should be able to see category page");
		//Choosing the Category of Alert Frame Windows
		choosingCategory category = new choosingCategory(driver);
		String category_actual = category.userChoosingTheCategory("Alerts, Frame & Windows");
		reportGenerator.verifyOutput(category_actual, "DEMOQA", "Successfully clicked category values", "Failed to click a category value");
		
		//Choosing the Browser windows
		reportGenerator.writeStep("Browser windows page","User should be able to see browser window page");
		category.InsideChoosingCategory("Browser Windows");
		ClickOnBrowserWindows browserWin = new ClickOnBrowserWindows(driver);
		String browserWin_actual = browserWin.clickBrowserWindows();
		reportGenerator.verifyOutput(browserWin_actual, "DEMOQA", "Successfully clicked on browser windows", "Failed to click a browser window");
		
		//Clicking a Alerts
		reportGenerator.writeStep("Alerts page","User should be able to see alerts page");
		category.InsideChoosingCategory("Alerts");
		ClickOnAlerts alerts = new ClickOnAlerts(driver);
		String alert_actual = alerts.clickAlerts();
		reportGenerator.verifyOutput(alert_actual, "DEMOQA", "Successfully handled alerts", "Failed to handle a alerts");
		
		//Clicking a Model Dialogs
		reportGenerator.writeStep("Model Dialogs page","User should be able to see model dialogs page");
		category.InsideChoosingCategory("Modal Dialogs");
		ClickOnModalDialogs model = new ClickOnModalDialogs(driver);
		String model_actual = model.clickModalDialogs();
		reportGenerator.verifyOutput(model_actual, "DEMOQA", "Successfully clicked a model dialogs", "Failed click a model dialogs");
	}
}

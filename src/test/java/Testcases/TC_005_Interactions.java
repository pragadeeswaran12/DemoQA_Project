package Testcases;

import org.testng.annotations.Test;
import commonsteps.choosingCategory;
import pageobjects_interactions.ClickOnDragable;
import pageobjects_interactions.ClickOnDropable;
import pageobjects_interactions.ClickOnSelectable;
import pageobjects_interactions.ClickOnSortable;
import util.baseClass;

public class TC_005_Interactions extends baseClass {
	@Test
	public void Interactions() throws Exception {
		reportGenerator.getAttributes("DemoQA", "Interactions", "Pragadees", "TC_005");
		
		//Choosing the Category of Interactions
		reportGenerator.writeStep("Interactions page","User should be able to see Interactions page");
		choosingCategory category = new choosingCategory(driver);
		String category_actual  =category.userChoosingTheCategory("Interactions");	
		reportGenerator.verifyOutput(category_actual, "DEMOQA", "Successfully clicked Interaction page", "Failed to click a Interaction page");
		
		//Sortable page
		reportGenerator.writeStep("Sortable page","User should be able see Sortable page");
		category.InsideChoosingCategory("Sortable");
		ClickOnSortable sort = new ClickOnSortable(driver);
		String sort_actual = sort.SortablePage();
		reportGenerator.verifyOutput(sort_actual, "DEMOQA", "Successfully sorted all the values", "Failed to sort a values");
		
		//Selectable page
		reportGenerator.writeStep("Selectable page","User should be able see Selectable page");
		category.InsideChoosingCategory("Selectable");
		ClickOnSelectable  select = new ClickOnSelectable(driver);
		String select_actual = select.ClickingSelectValue("Morbi leo risus");
		select.ClickingGridValue("Two");
		reportGenerator.verifyOutput(select_actual, "DEMOQA", "Successfully selected all the values", "Failed to select a details");
		
		//Dropable page
		reportGenerator.writeStep("Dropable page","User should be able see Dropable page");
		category.InsideChoosingCategory("Droppable");
		ClickOnDropable drop = new ClickOnDropable(driver);
		String drop_actual =drop.ClickDropable();
		reportGenerator.verifyOutput(drop_actual, "DEMOQA", "Successfully droped all the values", "Failed to drop the values");
		
		//Dragable page
		reportGenerator.writeStep("Dragable page","User should be able see Dragable page");
		category.InsideChoosingCategory("Dragabble");
		ClickOnDragable drag = new ClickOnDragable(driver);
		String drag_actual = drag.ClickDragable();
		reportGenerator.verifyOutput(drag_actual, "DEMOQA", "Successfully draged the values", "Failed to drag a values");
	}
}

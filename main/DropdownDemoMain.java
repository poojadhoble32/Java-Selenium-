package main;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownDemoMain {
	public static void main(String[] args) throws InterruptedException {
		String url ="https://demoqa.com/select-menu";

		WebDriver driver;
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver. manage(). window(). maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//@ Single select --------------------------------------------
		WebElement singleSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldSelectMenu")));
		Select oldMenuSingleSelect = new Select(singleSelect);

		System.out.println("Single select isMultiple: "+oldMenuSingleSelect.isMultiple());
		List<WebElement> selOptions = oldMenuSingleSelect.getOptions();
		System.out.println("Size of total items: "+selOptions.size());
		for(WebElement el : selOptions) {
			System.out.println("options are: "+el.getText());
			if(el.getText().contains("Pooja")) {

			}
		}

		//@ select by index of item. index starts from 0
		oldMenuSingleSelect.selectByIndex(2); Thread.sleep(5000); 
		//@ select by value present in select options. values in select options are present inside tag
		oldMenuSingleSelect.selectByValue("10"); Thread.sleep(5000); 
		//@ select by text in select options. text is present outside of tag
		oldMenuSingleSelect.selectByVisibleText("White"); Thread.sleep(5000);
		
		 css-1uccc91-singleValue
		 
		 //*[@class=" css-1hwfws3"]


		//@ Multi select --------------------------------------------	
		/*
		 * WebElement multiSelect =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cars")));
		 * Select multiItems = new Select(multiSelect);
		 * System.out.println("IsMultiSelect: "+multiItems.isMultiple());
		 */


	}
}
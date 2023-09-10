package main;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSwitchDemoMain {

	public static void main(String[] args) {
		String url ="https://demoqa.com/browser-windows";

		WebDriver driver;
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver,10);

		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow: "+parentWindow);

		WebElement newButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton")));
		newButton.click();

		Set<String> childWindows = driver.getWindowHandles();
		for(String window : childWindows) {
			System.out.println("window: "+window);
			if(!window.equals(parentWindow))
			{
				driver.switchTo().window(window);
				WebElement newWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
				System.out.println("NewWindow Value:"+newWindow.getText());
				driver.close();
				System.out.println("child widow closed");
			}
		} 
		
		driver.switchTo().window(parentWindow);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton")));
	    
	    System.out.println("success");
	
	    driver.close();
	}

}

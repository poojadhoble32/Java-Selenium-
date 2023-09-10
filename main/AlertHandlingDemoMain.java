package main;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandlingDemoMain {

	public static void main(String[] args) {
		String url ="https://demo.automationtesting.in/Alerts.html";
		
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver. manage(). window(). maximize();
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement firstAlertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#OKTab']")));
		firstAlertButton.click();
		
		WebElement firstAlertButtonNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='alertbox()']")));
		firstAlertButtonNext.click();
		
		//@ to accept first alert
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		WebElement secondAlertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#CancelTab']")));
		secondAlertButton.click();
		
		WebElement secondAlertButtonNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='confirmbox()']")));
		secondAlertButtonNext.click();
		
		//@ to accept second alert
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		secondAlertButtonNext.click();
		
		//@ to dismiss second alert
		Alert alert3 = driver.switchTo().alert();
		alert3.dismiss();	
		
		WebElement thirdAlertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#Textbox']")));
		thirdAlertButton.click();
		
		WebElement thirdAlertButtonNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='promptbox()']")));
		thirdAlertButtonNext.click();
		
		//@ to get text from 3rd alert and accept the alert
		Alert alert4 = driver.switchTo().alert();
		System.out.println("alert text: "+alert4.getText());
		alert4.accept();
		
		driver.close();

	}
}
package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NetflixLoginMain {

	public static void main(String args[]) throws InterruptedException {

		String url = "https://www.netflix.com/";
		String username = "A2305";
		String password = "12345";
		
		WebDriver driver;   //WebDriver class reference
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");                      // (web driver key as web driver name : value as driver path on local system) webdriver loaded
		driver = new EdgeDriver();      // object of edge web browser
		driver.manage().window().maximize();      // maximize web screen
		driver.get(url);              //entered on url
		Thread.sleep(5000);
		
		WebElement signInbutton;
		signInbutton = driver.findElement(By.xpath("//*[@class=' e1ax5wel1 default-ltr-cache-1b6vb2r']")); //this is relative xpath finded with class
		System.out.println("sign in button text: "+signInbutton.getText());
		signInbutton.click();
		Thread.sleep(5000);
		
		WebElement emailTextfield = driver.findElement(By.id("id_userLoginId"));   //finded by id
		emailTextfield.sendKeys(username);
		Thread.sleep(5000);
		
		WebElement passwordField = driver.findElement(By.id("id_password"));
		passwordField.sendKeys(password);   //enter value in field
		Thread.sleep(5000);
		
		WebElement signInClick = driver.findElement(By.xpath("//*[@data-uia = 'login-submit-button']")); //to find xpath/element ctrl+f
		signInClick.click();
		Thread.sleep(6000);
		
		WebElement errorMsg = driver.findElement(By.xpath("//*[@data-uia='text']"));
		System.out.println("Error Msg: "+errorMsg.getText());   //getText capture data 
		Thread.sleep(5000);
		
	
		driver.close();
		/*
		 * Operation operation = new Operation(url, username, password); 
		 * operation.startOperation();
		 */
	}
}

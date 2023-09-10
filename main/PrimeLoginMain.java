package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.GetElementText;

public class PrimeLoginMain {
	
	public static void main(String args[]) throws InterruptedException {
		
		String url = "https://www.primevideo.com/";
		String username = "";
		String password = "1234";
		
		WebDriver driver;
	    System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
	    driver = new EdgeDriver();
	    driver. manage(). window(). maximize();
	    driver.get(url);
	    Thread.sleep(4000);
		
	    WebElement signIn = driver.findElement(By.xpath("//*[text()='Sign in to join Prime']"));
	    signIn.click();
	    Thread.sleep(4000);
	    
	    WebElement emailTextField = driver.findElement(By.id("ap_email"));
	    emailTextField.sendKeys(username);
	    Thread.sleep(4000);
	    
	    WebElement passwordField = driver.findElement(By.id("ap_password"));
	    passwordField.sendKeys(password);
	    Thread.sleep(4000);
	    
	    WebElement signInClick = driver.findElement(By.id("signInSubmit"));
	    signInClick.click();
	    
	    WebElement errorMsg = driver.findElement(By.className("a-list-item"));
	    System.out.println("error msg"+errorMsg.getText());
	    
	    driver.close();
	}

}

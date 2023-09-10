package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3SchoolsMain {

	public static void main(String[] args)throws InterruptedException {

		String url = "https://www.w3schools.com/";
		String username = "poojadhoble32@gmail.com";
		String password = "Pooja@1234";

		WebDriver driver;
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver. manage(). window(). maximize();
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("w3loginbtn")));
		signIn.click();

		WebElement emailTextField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("modalusername")));
		emailTextField.sendKeys(username);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));
		passwordField.sendKeys(password);

		WebElement signInClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Log in']")));
		signInClick.click();

		String message ="";
		boolean loginSuccess = false;

		try {
			//@ invalid email id error
			WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='EmailInput_email_error__IJxXf']")));
			message = error.getText();		
			System.out.println("Error message: "+message);
		}
		catch(Exception e) 
		{
			try {
				//@ invalid username password error
				WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Alert_iwrp__5q1xH Alert_danger__Wsdhv']")));
				message = errorMsg.getText();
				System.out.println("Error message: "+message);
			}
			catch(Exception e1) {
				//@ Login success msg checking
				
				//@ switch to frame
				driver.switchTo().frame("classic-menu");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout-link")));
				driver.switchTo().defaultContent();
				loginSuccess = true;
			}
		}
		System.out.println("loginSuccess: "+loginSuccess);	
		
		WebElement blockText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='MainHeader_messagePanel__SA2Q3']")));
		System.out.println("Block Texts are:"+blockText.getText());
		
		driver.close();
	}
}

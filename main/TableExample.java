package main;

import java.io.InterruptedIOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableExample {
	public static void main(String args[])throws InterruptedIOException
	{
		String url = "https://www.dezlearn.com/webtable-example/";
		
		WebDriver driver; 
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='tg']/tbody/tr"));
		System.out.println("number of rows:"+row.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//*[@class='tg']/tbody/tr/td"));
		System.out.println("number of columns:"+columns.size());
		
		for(int i=2;i<=row.size();i++)
		{
			WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td["+1+"]")));   //"+i+" bcoz i replacing some value
			System.out.println("name : "+name.getText());
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td["+2+"]")));
			System.out.println("email : "+email.getText());
			WebElement standard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[3]/input")));
			standard.click();
			WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[4]/input")));
			premium.click();
			WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[5]/select"))); 
			Select sel = new Select(type);
			sel.selectByIndex(3);
			WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[6]/input")));
            comment.sendKeys("pooja");			
		}
	}

}

package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoojaCodeMain {

	public static void main(String[] args) {
		String url = "https://www.dezlearn.com/webtable-example/";

		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> rows = driver.findElements(By.xpath("//*[@class='tg']/tbody/tr"));
		System.out.println("rows size: " + rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("//*[@class='tg']/tbody/tr/th"));
		System.out.println("columns size: " + columns.size());

		for (int i = 2; i <= rows.size(); i++) {			
			  String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[1]"))).getText().trim();
			  System.out.println("name: "+name); 
			  String email =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@class='tg']/tbody/tr["+i+"]/td[2]"))).getText().trim();
			  System.out.println("email: "+email); 
			  WebElement standard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[3]/input"))); 
			  standard.click(); 
			  WebElement premium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[4]/input"))); 
			  premium.click(); 
			  WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[5]/select"))); 
			  Select type = new Select(dropdown); 
			  type.selectByValue("Sedan"); 
			  WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tg']/tbody/tr["+i+"]/td[6]/input")));
			  comment.sendKeys("test comment"); 
			  System.out.println("Done for row: "+i);
		}
	}
}
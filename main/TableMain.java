package main;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class TableMain {
	public static void main(String[] args) {
		String url ="https://demoqa.com/webtables";

		WebDriver driver;
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver. manage(). window(). maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//@ get total rows
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='rowgroup']")));
		List<WebElement> rows = driver.findElements(By.xpath("//*[@role='rowgroup']"));
		System.out.println("row size: "+rows.size());

		//@ get total columns
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='columnheader']")));
		List<WebElement> columns = driver.findElements(By.xpath("//*[@role='columnheader']"));
		System.out.println("columns size: "+columns.size());

		//@ code to read table data
		/*
		 * List<ArrayList> tableData = new ArrayList(); //@ for loop - for row for(int
		 * rowNum=1; rowNum<=rows.size(); rowNum++) { //@ for loop - for column
		 * ArrayList<String> columnData = new ArrayList<String>(); for(int colNum = 1 ;
		 * colNum<=columns.size(); colNum++) { WebElement col =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@role='rowgroup']["+rowNum+"]//*[@role='gridcell']["+colNum+"]")));
		 * columnData.add(col.getText()); } tableData.add(columnData); }
		 * System.out.println("tabledataSize: "+tableData.size());
		 * 
		 * //@ to print data from table for(ArrayList<String> arr : tableData) {
		 * System.out.println(arr); }
		 */


		//@ code to write into table data
		
		//@ read from file
		try {
			String filePath = "F:\\InputFiles\\CSVInput.csv";
			File file = new File(filePath);
			//@ Create an object of filereader class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);
			CSVParser parser = new CSVParserBuilder().withSeparator(',').build();

			//@ create csvReader object with parameter filereader and parser
			CSVReader csvReader = new CSVReaderBuilder(filereader)
					.withCSVParser(parser)
					.build();

			//@ Read all data at once
			List<String[]> allData = csvReader.readAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//@ write into web table


	}
}


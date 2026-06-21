package com.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	WebDriver driver;
	String URL = "https://www.login.hiox.com/login?referrer=easycalculation.com";
	@Test(dataProvider="EasyCalculation")
	public void TestBrowser(String username, String password) {
		driver = new ChromeDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("log_email")).sendKeys(username);
		driver.findElement(By.id("log_password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='log_submit']")).click();
	}
	
	
	@AfterMethod
	public void EndBrowser(){
		driver.quit();
	}
	
	
	@DataProvider(name="EasyCalculation")
	public Object[][] passData(){
		Object[][] data =  new Object[3][2];
		data[0][0] = "639234324";
		data[0][1] = "devanshb";
		
		data[1][0]  = "324324232";
		data[1][1] = "nncelncle";
		
		data[2][0] = "345435234";
		data[2][1] = "deniceuwnl";
		
		return data;
	}

}

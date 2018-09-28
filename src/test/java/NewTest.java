import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest
{
	
	public static void main(String args[])
	{
		NewTest t =new NewTest();
		t.test();
	}
	
	@Test
	public void test()  {
		  File file = new File("sample.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("webdriver.chrome.driver", "/root/driver/chromedriver");
			WebDriver driver=new ChromeDriver();
		
	
			//WebDriver driver = new FirefoxDriver();
				


			driver.get(prop.getProperty("URL"));
			driver.findElement(By.id("num1")).sendKeys(prop.getProperty("num1"));
			driver.findElement(By.id("op")).sendKeys(prop.getProperty("op"));
			driver.findElement(By.id("num2")).sendKeys(prop.getProperty("num2"));
			driver.findElement(By.id("Submit")).click();  
			
			//String expectedVal=prop.getProperty("result");
			String expectedVal=prop.getProperty("result");
		
			
			String actualVal=driver.findElement(By.id("result")).getAttribute("value");
			
			//WebElement abc=driver.findElement(By.id("result"));
			//String actualVal =abc.toString();
			
			AssertJUnit.assertEquals(expectedVal, actualVal);
			
			driver.quit();
			
	  }
}

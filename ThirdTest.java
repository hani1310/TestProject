package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ThirdTest {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium_zip\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		 	
		driver.navigate().to("https://weathershopper.pythonanywhere.com/");
		
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();

			
		String x = driver.findElement(By.id("temperature")).getText();
		System.out.println(x);
		
		String[] arrSplit_2 = x.split(" ");
		int tempInt = Integer.parseInt(arrSplit_2[0]);
  	
  			
		if (tempInt <= 19)
	{
  		
  		driver.findElement(By.xpath("//button[text()='Buy moisturizers']")).click();
		Thread.sleep(1500);
			
		List<WebElement> priceList = driver.findElements(By.xpath("//p[contains(text(),'Price')]"));
		System.out.println("The moisturizer price list");
			
		ArrayList<Integer> arrl = new ArrayList<Integer>();
				 
		for( WebElement i: priceList) 
		{
				
		String x1= i.getText();
				
					
		int PriceList = Integer.parseInt( x1.replaceAll("[^0-9]", ""));

		int y = (int) (PriceList);
		arrl.add(y);

				
		}
		System.out.println("Min");
			
		int minVal = (Collections.min(arrl));
			
		String buttonxpath = "//button[contains(@onclick,'"+minVal+"')]";
		System.out.println(buttonxpath);
			
			
		driver.findElement(By.xpath(buttonxpath)).click();
			
		driver.findElement(By.xpath("//button[text()='Cart - ']")).click();
			
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")).click();
		
		driver.switchTo().frame("stripe_checkout_app");
			
		driver.findElement(By.id("email")).sendKeys("selenium@mailinator.com");
			
		driver.findElement(By.id("card_number")).sendKeys("4242424242424242");
			
		driver.findElement(By.id("control")).sendKeys("396001");

		driver.findElement(By.id("cc-exp")).sendKeys("1220");
			
		driver.findElement(By.id("cc-csc")).sendKeys("123");
			
		driver.findElement(By.id("//button[text()='submitButton']")).click();
			
			
	}
			
			
	 else if (tempInt >= 35)
	 {
		 
		
			driver.findElement(By.xpath("//button[text()='Buy sunscreens']")).click();
			Thread.sleep(1500);
			
			
			//Price List of all product
			List<WebElement> p = driver.findElements(By.xpath("//p[contains(text(),'Price')]"));
			System.out.println("The sunscreen price list");
			
			ArrayList<Integer> arrl = new ArrayList<Integer>();

			for( WebElement i: p)
			{
				String x1= i.getText();
				int PriceList = Integer.parseInt( x1.replaceAll("[^0-9]", ""));
				
				int y = (int) (PriceList);
				arrl.add(y);
				
			}
			
			System.out.println("Min");
			int minVal = (Collections.min(arrl));	
			
			String buttonxpath = "//button[contains(@onclick,'"+minVal+"')]";
			System.out.println(buttonxpath);
			
				
			
			driver.findElement(By.xpath(buttonxpath)).click();
			
			driver.findElement(By.xpath("//button[text()='Cart - ']")).click();
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")).click();
			
			driver.switchTo().frame("stripe_checkout_app");
			
				
			driver.findElement(By.id("email")).sendKeys("selenium@mailinator.com");
			
			String cnum = "4242424242424242";
			
			for (char ch : cnum.toCharArray()) {
				
			switch (Integer.parseInt(String.valueOf(ch))){
				case 1:
			
			driver.findElement(By.id("card_number")).sendKeys(Keys.NUMPAD1);
			break;
					
				case 2:
					
					
				}
			}
	 }


			
			driver.findElement(By.id("cc-exp")).sendKeys("1220");
			
			driver.findElement(By.id("cc-csc")).sendKeys("123");
			
			driver.findElement(By.id("//button[text()='submitButton']")).click();
			
			
  	} 

  
  
  

  @AfterMethod
  public void afterMethod() {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0.7000)");	
		driver.close();
		
  }



  @Test
  public void mainTest() {
    throw new RuntimeException("Test not implemented");
    
  }
 
}

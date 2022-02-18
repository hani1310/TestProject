package com.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Third {
	

	private static final JavascriptExecutor driver = null;
	
		public static void main(String[] args) throws InterruptedException {
			//Driver of Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Selenium_zip\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		 	//Navigate the website
		driver.navigate().to("https://weathershopper.pythonanywhere.com/");
		
			//Wait command used
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			//Maximize the driver
		driver.manage().window().maximize();

			//String to int convert By inspect xpath
		String x = driver.findElement(By.id("temperature")).getText();
		
		System.out.println(x);
			//String convert to Integer
		String[] arrSplit_2 = x.split(" ");
    	int tempInt = Integer.parseInt(arrSplit_2[0]);
    	
    			//ifelse Statement for choosing moist or sunscreen with the help of Temperature
    	if (tempInt <= 19) {
    		
    			//To Buy Moisturizer Click Event.
			driver.findElement(By.xpath("//button[text()='Buy moisturizers']")).click();
			Thread.sleep(1500);
			
			
			
				//Price List of all product
			List<WebElement> priceList = driver.findElements(By.xpath("//p[contains(text(),'Price')]"));
			System.out.println("The moisturizer price list");
			
				//To Finding Min Number from the products
			ArrayList<Integer> arrl = new ArrayList<Integer>();
				//getting min price 
			for( WebElement i: priceList) 
			{
				
				String x1= i.getText();
				
					// parse is use to convert string to int 
				int PriceList = Integer.parseInt( x1.replaceAll("[^0-9]", ""));

				int y = (int) (PriceList);
				arrl.add(y);

				
				}
			System.out.println("Min");
			
				//to return minn element 
			int minVal = (Collections.min(arrl));
			
			String buttonxpath = "//button[contains(@onclick,'"+minVal+"')]";
			System.out.println(buttonxpath);
			
			
			
				// Add to cart
			driver.findElement(By.xpath(buttonxpath)).click();
			
			driver.findElement(By.xpath("//button[text()='Cart - ']")).click();
			
				//Add to pay
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")).click();
		
			driver.switchTo().frame("stripe_checkout_app");
			
				//Geting mail automatic with the help of SendKeys.
			
			driver.findElement(By.id("email")).sendKeys("selenium@mailinator.com");
			
				//card number
			driver.findElement(By.id("card_number")).sendKeys("4242424242424242");
			driver.findElement(By.id("control")).sendKeys("396001");

				//date and expiry of credit card
			driver.findElement(By.id("cc-exp")).sendKeys("1220");
			
				//cvv detail
			driver.findElement(By.id("cc-csc")).sendKeys("123");
			
				//pay button	
			driver.findElement(By.id("//button[text()='submitButton']")).click();
			
			
  	}
			
			
	 else if (tempInt >= 35) {
		 
		 //Buy Sunscreen Click Event.
	 }
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
			
				//Add to cart.
			
			driver.findElement(By.xpath(buttonxpath)).click();
			driver.findElement(By.xpath("//button[text()='Cart - ']")).click();
			
				//Add to Pay
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")).click();
			
			driver.switchTo().frame("stripe_checkout_app");
			
				////Geting mail automatic with the help of SendKeys.
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
//			driver.findElement(By.id("card_number")).sendKeys(Keys.NUMPAD4);

			
			driver.findElement(By.id("cc-exp")).sendKeys("1220");
			
			driver.findElement(By.id("cc-csc")).sendKeys("123");
			
			driver.findElement(By.id("//button[text()='submitButton']")).click();
    	} 

   
    
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scrollBy(0.7000)");	
	
		
		
		
		
		
		
		
		
		
		
		
	 
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

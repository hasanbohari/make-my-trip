
//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
//import java.io.*;
//import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import io.netty.handler.timeout.TimeoutException;

//import net.bytebuddy.implementation.bind.annotation.DefaultCall.Binder.DefaultMethodLocator.Implicit;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class FirstProject {
	
	static void actionDoubleClick(WebDriver driver, String path ) {
//	    System.out.println("I just got executed!");
	    Actions builder = new Actions (driver);
		 WebElement from =  driver.findElement(By.xpath(path));
		Action seriesOfActions = builder
		 	.moveToElement(from)
		 	.doubleClick()
		 	.build();
		 	
		 seriesOfActions.perform() ;
	  }
	
	static void actionClick(WebDriver driver, String path ) {
		driver.findElement(By.xpath(path)).click();
	  }
	
	static void actionSendKeys(WebDriver driver, String path , String text ) {
		driver.findElement(By.xpath(path)).sendKeys(text);
	  }
	
	static void actionWait( int milisec) {
		try {
	        TimeUnit.MILLISECONDS.sleep(milisec);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANIL BHANDI\\Downloads\\chromedriver_win32\\chromedriver.exe");  
		 WebDriver driver=new ChromeDriver();  
		 
		 driver.get("http://www.makemytrip.com/");
		 driver.manage().window().maximize();
		 
		 actionWait(5000);
		 
		
		 
		 actionClick(driver, "//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]/div[2]");
		 
		 actionWait(2000);
		 
		 driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		 driver.findElement(By.xpath("//label[@for = 'fromCity']")).click();
		 driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");
		 actionDoubleClick(driver, "//li[@id='react-autowhatever-1-section-0-item-0']");
		 
		 
		 actionClick(driver, "//label[@for='toCity']");
		 actionSendKeys(driver, "//input[@placeholder='To']", "Goa");
		 actionDoubleClick(driver, "//*[@id='react-autowhatever-1-section-0-item-1']/div/div[1]/p[1]");
		 
		 actionClick(driver, "//label[@for='departure']");
		 actionClick(driver, "//div[@aria-label='Tue Nov 30 2021']");
	
		 actionClick(driver, "//p[@data-cy='returnDefaultText']");
		 actionClick(driver, "//div[@aria-label='Wed Dec 15 2021']");
		 actionClick(driver, "//p[@data-cy='submit']/a");
		 
		 actionWait(10000);
		 driver.close();
	}

}

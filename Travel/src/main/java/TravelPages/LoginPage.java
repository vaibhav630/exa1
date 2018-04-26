package TravelPages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {

	WebDriver driver = null;
	
	public void smain() {
		// TODO Auto-generated method stub
		System.out.println("Added a new class");

	}

	@Test(priority=0)
	public void login() throws InterruptedException{ 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();

		// Create reference variable “log” referencing getLogger method of Logger class, it is used to store logs in selenium.txt
		Logger log = Logger.getLogger("devpinoyLogger");

		driver.get("http://www.way2automation.com/demo.html");
		log.debug("navigated to way2automation");
		// Call debug method with the help of referencing variable log and log the information in test.logs file

		//driver.manage().window().maximize();

		String winHandleBefore = driver.getWindowHandle();

		driver.findElement(By.xpath(".//*[@id='toggleNav']/li[6]/a")).click();
		log.debug("navigated to something");

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			if(!winHandle.equals(winHandleBefore))
			{
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());

				Thread.sleep(3000);

				driver.findElement(By.linkText("Signin")).click(); 
				driver.findElement(By.xpath(".//fieldset[1]/input[@name='username']")).sendKeys("Vaibhav");
				driver.findElement(By.xpath(".//fieldset[2]/input[@name='password']")).sendKeys("abnhibhulungaW123");

				List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='button']"));
				list1.get(1).click(); 
			}

		}
	}
}
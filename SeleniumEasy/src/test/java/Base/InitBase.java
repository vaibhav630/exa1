package Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InitBase {
	
	public static WebDriver driver = null;
	
	@Test
	public void init() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\QATools\\chromedriver_2.36\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumeasy.com/test/");
		//driver.findElement(By.className("glyphicon glyphicon-home")).click();
		driver.findElement(By.id("btn_basic_example")).click();
		Thread.sleep(1000);
		//simpleFormDemo(driver);
		//checkBoxDemo(driver);
		radioButtonsDemo(driver);
		
		
	}
	
	
	public void simpleFormDemo(WebDriver driver) throws InterruptedException{
		driver.findElement(By.xpath("(//a[text()='Simple Form Demo'])[last()]")).click();
		driver.findElement(By.id("user-message")).sendKeys("Hi ! I am here.");
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@id='display']")).getText());
		driver.findElement(By.id("sum1")).sendKeys("2");
		driver.findElement(By.id("sum2")).sendKeys("3");
		driver.findElement(By.xpath("//button[text()='Get Total']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@id='displayvalue']")).getText());
	}
	
	public void checkBoxDemo(WebDriver driver){
		driver.findElement(By.xpath("//a[text()='Check Box Demo']")).click();
		driver.findElement(By.id("isAgeSelected")).click();
		System.out.println(driver.findElement(By.id("txtAge")).getText());
		driver.findElement(By.id("check1")).click();
		System.out.println(driver.findElement(By.id("check1")).getText());  //print uncheck all
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		checkBoxes.get(4).click();
		//driver.findElement(By.xpath("//input[text()='Option 4']")).click();
		System.out.println(driver.findElement(By.id("check1")).getText()); //print check all
		
	}
	
	public void radioButtonsDemo(WebDriver driver){
		driver.findElement(By.xpath("(//a[text()='Radio Buttons Demo'])[last()]")).click();
		List<WebElement> genderM = driver.findElements(By.xpath("//input[@value='Male']"));
		List<WebElement> genderF = driver.findElements(By.xpath("//input[@value='Female']"));
		
		genderM.get(0).click();
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println(driver.findElement(By.className("radiobutton")).getText());
		
		genderF.get(0).click();
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println(driver.findElement(By.className("radiobutton")).getText());
		
		genderM.get(1).click();
		driver.findElement(By.xpath("//input[@value='0 - 5']")).click();
		driver.findElement(By.xpath("//button[text()='Get values']")).click();
		String test = driver.findElement(By.className("groupradiobutton")).getText();
		System.out.println(test);
		
	}
	

}

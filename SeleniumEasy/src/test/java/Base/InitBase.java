package Base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InitBase {
	
	public WebDriver driver = null;
	
	@Test
	public void init() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaibhavsharma\\Desktop\\exa1\\exa1\\SeleniumEasy\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumeasy.com/test/");
		//driver.findElement(By.className("glyphicon glyphicon-home")).click();
		driver.findElement(By.id("btn_basic_example")).click();
		Thread.sleep(1000);
		//simpleFormDemo(driver);
		//checkBoxDemo(driver);
		//radioButtonsDemo(driver);
		//selectDropdownList(driver);
		javascriptAlerts(driver);
		
		
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
	
	public void selectDropdownList(WebDriver driver){
		driver.findElement(By.xpath("(//a[text()='Select Dropdown List'])[last()]")).click();
		
		driver.findElement(By.id("select-demo")).click();
		Select sel = new Select(driver.findElement(By.id("select-demo")));
		sel.selectByVisibleText("Wednesday");
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Day selected')]")).getText());
		
		Select multi = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
		multi.selectByIndex(1);
		multi.selectByVisibleText("Florida");
		multi.selectByVisibleText("Washington");
		multi.selectByVisibleText("New York");
		multi.selectByValue("Ohio");
		driver.findElement(By.xpath("//button[text()='First Selected']")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'First selected')]")).getText());
		
	    driver.findElement(By.xpath("//button[text()='Get All Selected']")).click();
    	System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Options selected')]")).getText());	
	}
	
	public void javascriptAlerts(WebDriver driver){
		driver.findElement(By.xpath("(//a[text()='Javascript Alerts'])[last()]")).click();
		
		driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
		driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
		System.out.println(al.getText());
		al.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You pressed')]")).getText());
		
		driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
		al.accept();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You pressed')]")).getText());
		
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		al.sendKeys("Vaibhav");
		al.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		al.sendKeys("Vaibhav Sharma");
		al.accept();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You have entered')]")).getText());
	}
	
	public void bootstrapAlerts(WebDriver driver){
		driver.findElement(By.xpath("(//a[text()='Bootstrap Alerts'])[last()]")).click();
		
		List<WebElement> auto = driver.findElements(By.xpath("//button[contains(text(),'Autocloseable')]"));
		for(int i:auto){
		auto.get(i).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'autocloseable')]")).getText());
		}
				
		
	}

}

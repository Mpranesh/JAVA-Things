package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusPlay {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

// From location
		driver.findElement(By.id("src")).sendKeys("C");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='autoFill']//li[1]")).click();

// To location
		driver.findElement(By.id("dest")).sendKeys("Mad");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		driver.findElement(By.id("onward_cal")).click();

// Date selection
		driver.findElement(By.xpath("//button[text()='>']")).click();
		driver.findElement(By.xpath("//td[text()='5']")).click();
// Search
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(4000);

// click cross icon
		driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(2000);

// Total bus available
		String bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total number of bus found is " + bus);
		Thread.sleep(2000);

//check box for sleeper
		driver.findElement(By.xpath("(//label[@class='custom-checkbox'])[6]")).click();
		Thread.sleep(2000);
// No of available sleeper buses
		String sleeper = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
    	System.out.println("Total number of SleeperBus found is " + sleeper);
		Thread.sleep(2000);
//Sleeper AC bus
		driver.findElement(By.xpath("//label[text()='AC']")).click();
        String AC = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total number of Ac Bus found is " + AC);
		
		driver.close();

	}
}

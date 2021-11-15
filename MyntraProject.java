package summa;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraProject {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions builder = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
		builder.moveToElement(women).perform();
		// Click jackets & coats
		driver.findElement(By.linkText("Jackets & Coats")).click();
		Thread.sleep(3000);

		// Find total count of item (Top)
		String Total = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		
		int Totalcount = Integer.parseInt(Total);
		System.out.println("Total count of item:" + Totalcount);

		// Validate the sum of categories count matches
		String jacketscount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String coatscount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		
		int jcount = Integer.parseInt(jacketscount);
		int ccount = Integer.parseInt(coatscount);
		int jacketcoats = jcount + ccount;
		System.out.println("JacketsCount + CoatsCount =" + jacketcoats);
		if (Totalcount == jacketcoats)
			System.out.println("The Sum of jackets and coats matches with the total.");
		else
			System.out.println("Count not matched.");

		// Check coats
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();

		// Click +more options
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();

		// Type brand name and click CHECKBOX
		driver.findElement(By.xpath("(//input[@class='FilterDirectory-searchInput'])[1]")).sendKeys("Mango");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']/div")).click();

		// Close the pop-up (x)
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']/span")).click();
		Thread.sleep(2000);

		// Confirm all the coats are of brand MANGO
	 java.util.List<WebElement> brandList = driver.findElements(By.xpath("//h3[@class='product-brand']"));

		for (WebElement eachBrand : brandList) {
			String brand = eachBrand.getText();
			System.out.println("BrandName:" + brand);
		}

		// Sort by Better Discount

		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(sortBy).build().perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(2000);

		// Find the price of the first Dislayed item
	  java.util.List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		String price = priceList.get(0).getText();
		System.out.println("price of the first displayed item:" + price);
		Thread.sleep(2000);

		// Mouse over on size of the first item
		WebElement elesize = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]"));
		builder.moveToElement(elesize).perform();
		Thread.sleep(2000);

		// Click on WishList Now
		driver.findElement(By.xpath("(//span[text()='wishlist'])[1]")) .click();

		// Close the Browser
		driver.close();

	}

}
		
		
		
	
		
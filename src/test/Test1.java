package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1 {

	private WebDriver CMDR;
	
	@Before
	public void setUp() 
	{
		CMDR = new ChromeDriver();
		CMDR.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		String userName = "test";
		String passWord = "test";
		CMDR.navigate().to("http://thedemosite.co.uk/");
		Thread.sleep(2500);
		CMDR.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		Thread.sleep(2500);
		CMDR.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(userName);
		Thread.sleep(2500);
		CMDR.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys(passWord);
		Thread.sleep(2500);
		CMDR.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(2500);
		CMDR.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		Thread.sleep(2500);
		CMDR.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys(userName);
		Thread.sleep(2500);
		CMDR.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys(passWord);
		Thread.sleep(2500);
		CMDR.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(2500);
		WebElement var = CMDR.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		Thread.sleep(2500);
		assertEquals("Text does not match",var.getText(),"**Successful Login**");
		
	}
	
	@After
	public void after()
	{
		CMDR.quit();
	}
	
	
	
	
	

}

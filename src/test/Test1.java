package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class Test1 {
	
	private Navigation N;
	private RegisterPage R;
	private LoginPage L;

	private WebDriver CMDR;
	
	@Before
	public void setUp() 
	{
		CMDR = new ChromeDriver();
		CMDR.manage().window().maximize();
		
		N = PageFactory.initElements(CMDR, Navigation.class);
		R = PageFactory.initElements(CMDR, RegisterPage.class);
		L = PageFactory.initElements(CMDR, LoginPage.class);
	}

	@Test
	public void test() throws InterruptedException {
		String userName = "test";
		String passWord = "test";
		
		CMDR.navigate().to("http://thedemosite.co.uk/");
		Thread.sleep(2000);
		
		N.clickadduser();
		Thread.sleep(2000);
		R.enterUserName(userName);
		Thread.sleep(2000);
		R.enterPassword(passWord);
		R.clickSubmit();
		Thread.sleep(2000);
		N.clicklogin();
		Thread.sleep(2000);
		L.enterUserName(userName);
		Thread.sleep(2000);
		L.enterPassword(passWord);
		Thread.sleep(2000);
		L.clickSubmit();
		
		
		/*CMDR.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		Thread.sleep(2000);
		CMDR.findElement(By.cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(1) td:nth-child(2) input")).sendKeys(userName);
		Thread.sleep(2000);
		CMDR.findElement(By.cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(2) input[type=\"password\"]")).sendKeys(passWord);
		Thread.sleep(2000);
		CMDR.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(2000);
		CMDR.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		Thread.sleep(2000);
		CMDR.findElement(By.cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(1) td:nth-child(2)  input")).sendKeys(userName);
		Thread.sleep(2000);
		CMDR.findElement(By.cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(2) td:nth-child(2)  input[type=\"password\"]")).sendKeys(passWord);
		Thread.sleep(2000);
		CMDR.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(2000);*/
		
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

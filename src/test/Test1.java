package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Test1 {

	private Navigation N;
	private RegisterPage R;
	private LoginPage L;
	private WebDriver CMDR;
	private ScreenShot S;
	
	private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "Report.html";
    
	
	@Before
	public void setUp() {
		CMDR = new ChromeDriver();
		CMDR.manage().window().maximize();

		N = PageFactory.initElements(CMDR, Navigation.class);
		R = PageFactory.initElements(CMDR, RegisterPage.class);
		L = PageFactory.initElements(CMDR, LoginPage.class);
		
	}

	@Test
	public void test() throws InterruptedException, IOException {
		String userName = "test";
		String passWord = "test";
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);


		CMDR.navigate().to("http://thedemosite.co.uk/");
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.addUserx));
			}
		});
		
		N.clickadduser();
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.cssSelector(R.userNameInputcss));
			}
		});
		
		R.enterUserName(userName);
		//Thread.sleep(2000);
		
		R.enterPassword(passWord);
		
		R.clickSubmit();
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.loginx));
			}
		});
		
		N.clicklogin();
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.cssSelector(L.userNameInputcss));
			}
		});
		
		L.enterUserName(userName);
		//Thread.sleep(2000);
		
		L.enterPassword(passWord);
		L.clickSubmit();

		/*
		 * CMDR.findElement(By.xpath(
		 * "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"
		 * )).click(); Thread.sleep(2000); CMDR.findElement(By.
		 * cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(1) td:nth-child(2) input"
		 * )).sendKeys(userName); Thread.sleep(2000); CMDR.findElement(By.
		 * cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(2) input[type=\"password\"]"
		 * )).sendKeys(passWord); Thread.sleep(2000); CMDR.findElement(By.xpath(
		 * "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"
		 * )).click(); Thread.sleep(2000); CMDR.findElement(By.xpath(
		 * "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"
		 * )).click(); Thread.sleep(2000); CMDR.findElement(By.
		 * cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(1) td:nth-child(2)  input"
		 * )).sendKeys(userName); Thread.sleep(2000); CMDR.findElement(By.
		 * cssSelector("td.auto-style1  td:nth-child(1)  tr:nth-child(2) td:nth-child(2)  input[type=\"password\"]"
		 * )).sendKeys(passWord); Thread.sleep(2000); CMDR.findElement(By.xpath(
		 * "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"
		 * )).click(); Thread.sleep(2000);
		 */

		WebElement check = CMDR
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("Text does not match", check.getText(), "**Successful Login**");
		
		
		report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Test1_report");
        extentHtmlReporter.config().setDocumentTitle("Test1_report");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Test1");
        
        
        test.log(
				Status.INFO,
				"Error Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Report")));
        
        
        
        test.log(Status.INFO,"Info level");

	}

	@After
	public void after() {
		
		CMDR.quit();
		report.flush();
	}

}

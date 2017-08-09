package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.util.SystemOutLogger;
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
	
	private SpreadSheetReader SR;
	//private ScreenShot S;
	
	private static ExtentReports report;
    private static ExtentTest test;
    private static String reportFilePath = "Report.html";
    
    @BeforeClass
    public static void report(){
    	report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Test1_report");
        extentHtmlReporter.config().setDocumentTitle("Test1_report");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Test1");
    	
    }
    
	
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
		//String userName = "test";
		//String passWord = "test";
		String testObject = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b";
		
		String targetWebsite = "http://thedemosite.co.uk/";
		
		SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "\\Testdata.xlsx");
        List<String> row = sheetReader.readRow(1, "Test_info");
        String userName = row.get(2);
        String passWord = row.get(3);
        
        List<String> row2 = sheetReader.readRow(1, "Test_expectedResult");
        String expectedResult = row2.get(1);
        
        
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		

		CMDR.navigate().to(targetWebsite);
		test.log(Status.INFO,"Target website is " + targetWebsite);
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.addUserx));
			}
		});
		
		N.clickadduser();
		test.log(Status.INFO,"Clicking adduser in the navigation bar");
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.cssSelector(R.userNameInputcss));
			}
		});
		
		R.enterUserName(userName);
		test.log(Status.INFO,"Entering username for register");
		//Thread.sleep(2000);
		
		R.enterPassword(passWord);
		test.log(Status.INFO,"Entering password for register");
		
		R.clickSubmit();
		test.log(Status.INFO,"Submitting register");
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.loginx));
			}
		});
		
		N.clicklogin();
		test.log(Status.INFO,"Clicking Login in the navigation bar");
		//Thread.sleep(2000);
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.cssSelector(L.userNameInputcss));
			}
		});
		
		L.enterUserName(userName);
		test.log(Status.INFO,"Entering username for Login");
		//Thread.sleep(2000);
		
		L.enterPassword(passWord);
		test.log(Status.INFO,"Entering password for Login");
		L.clickSubmit();
		test.log(Status.INFO,"Submitting Login");


		WebElement check = CMDR
				.findElement(By.xpath(testObject));
		
		assertEquals("Text does not match", check.getText(), expectedResult);
		
        
		if (!expectedResult.equals(check.getText()))
		{
			test.fail("Test does not match, test failed");
		}
		else
			test.pass("Matching test found, test passed");


		
        test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Report")));
        
        
        
        //test.log(Status.INFO,"Info level");
        

	}


	@After
	public void after() {
		
		System.out.println(test.getStatus());
		CMDR.quit();
		report.flush();
	}

}

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
 * )).click(); Thread.sleep(2000);*/

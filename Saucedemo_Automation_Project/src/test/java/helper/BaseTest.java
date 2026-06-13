package helper;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

//public class BaseTest {
//  public WebDriver wd;
//  public Properties prop;
//  public ExtentReports extent;
//  public ExtentTest test;
//  public static Logger Log= LogManager.getLogger(BaseTest.class);
//  @BeforeMethod
// 
//	  public void initialize_n_OpenBrowser(Method method) throws IOException {
//		  test = extent.createTest(method.getName());
//		  prop = new Properties();
//		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
//		  prop.load(fis);
//		  
//		  String browser = prop.getProperty("browser");
//		  if(browser.equalsIgnoreCase("edge")) {
//			  wd = new EdgeDriver();
//		  }
//		  else if (browser.equalsIgnoreCase("chrome")){
//			  wd = new ChromeDriver();
//		  }
//		  wd.manage().window().maximize();
//		  wd.get(prop.getProperty("url"));
//		  Log.info("Browser launched and navigated to URL");
//	  }
//  
//
//  @AfterMethod
//  public void closeBrowser() {
//	  wd.quit();
//	  Log.info("Browser closed");
//  }
//
////  @AfterSuite
////  public void flushReport() {
////	  extent.flush();
////	  
////  }
//
// // @BeforeSuite
////  public void setupReport() {
////	  extent = ExtentManager_Utility.createInstance();
////  }

//}


public class BaseTest {

    public WebDriver wd;
    public ExtentReports extent;
    public ExtentTest test;
    public static Logger Log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("Reports/report.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void initialize_n_OpenBrowser(Method method) {

        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        test = extent.createTest(method.getName());

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void closeBrowser() {
        wd.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}

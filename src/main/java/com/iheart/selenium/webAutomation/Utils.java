package com.iheart.selenium.webAutomation;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;




public class Utils {
	public static final String browserStack_USERNAME = "robrowe";
	public static final String browserStack_AUTOMATE_KEY = "SGtW65fVhR9zqp7KpVUo";
	public static final String browserStack_URL = "http://" + browserStack_USERNAME + ":" + browserStack_AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";


	public static WebDriver  createWebDriver() 
	
	{
	
	return createWebDriver("firefox");
	
	}
	
	
	public static WebDriver  createWebDriver(String browser) 
	
	{   WebDriver driver;
	
	    if (browser.equalsIgnoreCase("firefox"))
	
	        driver = new FirefoxDriver();
	
	    else if (browser.equalsIgnoreCase("chrome"))
	    {   //Set actual path to the driver file
	
	       System.setProperty("webdriver.chrome.driver", "C:\\Users\\mmatos\\git\\lib\\chromedriver.exe");
	      //System.setProperty("webdriver.chrome.driver", "C:\\Users\\1111128\\git\\drivers\\chromedriver.exe");
	    //	System.setProperty("webdriver.chrome.driver", "/Users/1111128/git/drivers/chromedriver");
	  	  
	  
	      ChromeOptions options = new ChromeOptions();
	      options.addArguments("test-type");
	      options.addArguments("--start-maximized");
	     
	      driver = new ChromeDriver(options);
	
	      }else if (browser.equalsIgnoreCase("ie"))
	      {    //Set actual path to the driver file
	
	      System.setProperty("webdriver.ie.driver","C:\\Users\\1111128\\workspace\\drivers\\IEDriverServer.exe");
	
	      
	      driver = new InternetExplorerDriver();
	
	      }else 
	
	      {
	
	      System.out.println("Unknown browser.");
	
	      return null;
	
	      }
	
	      driver.manage().window().maximize();
	
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	      return driver;
	
	  }
	
	public static WebDriver  createRemoteDriver(CapabilitySetting setting) 
	{  
		WebDriver driver;
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", setting.getBrowser());
	    caps.setCapability("browser_version", setting.getBrowserVersion());
	    caps.setCapability("os", setting.getOsName());
	    caps.setCapability("os_version", setting.getOs_version());
	    caps.setCapability("browserstack.debug", "true");
	   
	    try{
	       driver = new RemoteWebDriver(new URL(browserStack_URL), caps);
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	return null;
	    }
	    driver.manage().window().maximize();
	
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	    return driver;
	
	  }
	
	public static WebDriver  createRemoteDriver(String browser,String browserVersion, String osName, String os_version) 
	{  
		WebDriver driver;
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", browser);
	    caps.setCapability("browser_version", browserVersion);
	    caps.setCapability("os", osName);
	    caps.setCapability("os_version", os_version);
	    caps.setCapability("browserstack.debug", "true");
	   
	    try{
	       driver = new RemoteWebDriver(new URL(browserStack_URL), caps);
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	return null;
	    }
	    driver.manage().window().maximize();
	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	    return driver;
	
	  }
	
	
	
	
	public static void waitForPageToLoad(WebDriver driver) {
	    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	
	        public Boolean apply(WebDriver driver) {
	
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	
	        }
	
	      };
	
	    Wait<WebDriver> wait = new WebDriverWait(driver,1000);
	
	      try {
	
	              wait.until(expectation);
	
	      } catch(Throwable error) {
	
	              System.out.println("Timeout waiting for Page Load Request to complete.");
	
	      }
	
	} 
	
	
	
	
	public static WebDriver launchBrowser(String url, String browser)
	{       Page.setBrowser(browser);
			WebDriver driver = createWebDriver(browser);
			
			driver.get(url);
			//WaitUtility.waitForAjax(driver);
			WaitUtility.sleep(1000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
	
	}
	
	public static WebDriver launchBrowserInCloud(String url, CapabilitySetting setting)
	{
			WebDriver driver = createRemoteDriver(setting);
			
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
	
	}
	
	public static int getRandomInt()
	{
		Random randomGenerator = new Random();
	  
	    int randomInt = randomGenerator.nextInt(999999);
	     
	    return randomInt;
	    
	}
	
	public static Map<String, String> getLocationByIp(WebDriver driver)
	{    Map<String, String> geoInfo = new HashMap<String, String>();
		 driver.navigate().to("http://www.iplocation.net");
		 String country = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		 String state = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(3)")).getText();
		 String city = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4)")).getText();
		 
		 geoInfo.put("country", country);
		 geoInfo.put("state", state);
		 geoInfo.put("city", city);
		 
		 
		 
		 return geoInfo;
	}
	

}

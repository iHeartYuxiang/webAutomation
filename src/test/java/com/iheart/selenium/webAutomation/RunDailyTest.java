package com.iheart.selenium.webAutomation;


import com.iheart.selenium.webAutomation.*;

import java.io.File;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunDailyTest {


	WebDriver driver;
	
	HomePage homePage;
	LiveRadioPage liveRadioPage;
	CustomRadioPage customRadioPage;
	PodcastsPage podcastsPage;
	PerfectForPage perfectForPage;
	ProfilePage profilePage;
	
	
		String browser = "firefox";
	//String browser = "chrome";
	
	static String userCity = "";
	
	 
	final String URL = "http://www.iheart.com";
	
	@Rule public TestName name = new TestName();
	
	
	@Before
    public void init() {
        driver = Utils.launchBrowser(URL, browser);
        Page.setDriver (driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
        liveRadioPage = PageFactory.initElements(driver, LiveRadioPage.class);
        customRadioPage = PageFactory.initElements(driver, CustomRadioPage.class);
        podcastsPage = PageFactory.initElements(driver, PodcastsPage.class);
        perfectForPage = PageFactory.initElements(driver, PerfectForPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
       
        Page.getErrors().delete(0, Page.getErrors().length());
    }
    
    
		 @Test
	     public void testWEB_11779_playStations() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            profilePage.WEB_11779_playStations();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }  
	         System.out.println(name.getMethodName() + " is Done.");
	     }

/*

	    @Test
	    public void testWEB_11734_startUp() throws Exception
	    {
	        System.out.println("test method:" +  name.getMethodName() );
	        try{
	           homePage.WEB_11734_startUp();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }
	              System.out.println(name.getMethodName() + " is Done.");
	            
	    }
	
	   
	     
	    
	     
	     @Test
	        public void testWEB_11740_search() throws Exception
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            try{
	                   homePage.WEB_11740_search();
	            }catch(Exception e)
	             {
	                 handleException(e);
	             }        
	            System.out.println(name.getMethodName() + " is Done.");
	        }
	     
	   
	     
	        @Test
	     public void testWEB_11736_signUp() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             homePage.WEB_11736_signUp();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	        
	     
	     @Test
	        public void testWEB_11737_loginWithEmail() throws Exception
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            try{
	                   homePage.WEB_11737_loginWithEmail();
	            }catch(Exception e)
	             {
	                 handleException(e);
	             }        
	            System.out.println(name.getMethodName() + " is Done.");
	            
	        }
	     
	  
	     
	     @Test
	        public void testWEB_8823_FaceBookSignUp() throws Exception
	        {
	           
	            System.out.println("test method:" +  name.getMethodName() );
	            try{
	                   homePage.WEB_8823_faceBooksignUp();
	            }catch(Exception e)
	             {
	                 handleException(e);
	             } 
	            System.out.println(name.getMethodName() + " is Done.");
	            
	        }
	     
	     
	     
	     @Test
	     public void testWEB_11738_FACEBOOKsignUp() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             homePage.WEB_11738_FACEBOOKsignUp();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	        public void testWEB_11739_loginWithGoog() throws Exception
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            try{
	                   homePage.WEB_11739_loginWithGoog();
	            }catch(Exception e)
	             {
	                 handleException(e);
	             }        
	            System.out.println(name.getMethodName() + " is Done.");
	        }
	     
	     
	     
	     @Test
	     public void testWEB_11752_thumbUpLiveRadio() throws Exception
	     {   System.out.println("Using new code...."  );
	         System.out.println("test method:" +  name.getMethodName() );
	         try
	        {
	            liveRadioPage.WEB_11752_thumpUp();
	        }catch(Exception e)
	        {
	            handleException(e);
	        }
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     
	     @Test
	        public void testWEB_11744_filterStation() throws Exception
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            try
	            {
	               liveRadioPage.WEB_11744_filterStation();
	            }catch(Exception e)
	            {
	                handleException(e);
	            }
	            System.out.println(name.getMethodName() + " is Done.");
	        }
	     
	     @Test
	     public void testWEB_11761_filterAndPlayCustomAfterLogin() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            customRadioPage.WEB_11761_filterAndPlayCustomAfterLogin();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }  
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     
	     @Test
	     public void testWEB_11763_thumpUpCustom() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            customRadioPage.WEB_11763_thumpUpCustom();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }  
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11766_browsePerfect() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             perfectForPage.WEB_11766_browsePerfect();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11776_thumbUpPodcasts() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             podcastsPage.WEB_11776_thumbUp();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11774_filterPodAfterLogin() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             podcastsPage.WEB_11774_filterPodAfterLogin();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11782_friendPage() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	             profilePage.WEB_11782_friendPage();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }    
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	    @Ignore("Skip this for now due to hang on facebook.com")
	     public void testWEB_11779_playStations() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            profilePage.WEB_11779_playStations();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }  
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Ignore("Skip this for now due to hang on facebook.com")
	     public void testWEB_11780_playStationsInMyStationsPage() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            profilePage.WEB_11780_playStationsInMyStationsPage();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11783_logout() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try{
	            profilePage.WEB_11783_logout();
	         }catch(Exception e)
	         {
	             handleException(e);
	         }      
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	        public void testWEB_18302_PopularUserFlow() 
	        {
	            System.out.println("test method:" +  name.getMethodName() );
	            driver.get("http://www.z100.com");
	            homePage.flowAlong();
	            System.out.println(name.getMethodName() + " is Done.");
	        }
	    
	     @Test
	     public void testWEB_11754_thumpDownLiveRadio() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try
	        {
	             liveRadioPage.WEB_11754_thumpDown();
	        }catch(Exception e)
	        {
	            handleException(e);
	        }
	         System.out.println(name.getMethodName() + " is Done.");
	     }
	     
	     @Test
	     public void testWEB_11750_filterLiveStationAfterLogin() throws Exception
	     {   
	         System.out.println("test method:" +  name.getMethodName() );
	         try
	        {
	             liveRadioPage.WEB_11750_filterLiveStationAfterLogin();
	        }catch(Exception e)
	        {
	            handleException(e);
	        }
	         System.out.println(name.getMethodName() + " is Done.");
	     }
*/	     
	
	     @After
		    public void tearDown() throws Exception{
	    	   
		    	if (Page.getErrors().length() > 0)
					 fail(Page.getErrors().toString());
		    	   
		    	
		    }
		
		    private void handleException(Exception e)
		    {   Page.getErrors().append("Exception is thrown.");
		        e.printStackTrace();
		        /*
	            try{
		    	   Page.takeScreenshot(driver, name.getMethodName());
	            }catch(Exception eX)
	            {
	            	
	            }
	            */
		    }
		    
		   
		    
		    @Rule
		    public TestRule watcher = new TestWatcher() {
		        @Override
		        public void finished(Description description) {
		            driver.quit();
		        }

		        @Override
		        public void failed(Throwable e, Description description) {
		          
		        	try {
		               
		        		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		               // String filePathRoot = "C:\\_Jenkins\\workspace\\" + jenkinsJobName + "\\target\\surefire-reports\\";
		        		String currentPath =  System.getProperty("user.dir");
		        		String path = currentPath + "\\target\\surefire-reports\\";
		        		
		                String fullFilePath = path + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

		                FileUtils.copyFile(screenshot, new File(fullFilePath));
		                
		        		
		            } catch(Exception ex) {
		                System.out.println(ex.toString());
		                System.out.println(ex.getMessage());
		            }

		            driver.quit();
		        }
		    };
	
}

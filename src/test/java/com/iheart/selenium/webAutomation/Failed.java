package com.iheart.selenium.webAutomation;


import com.iheart.selenium.webAutomation.*;

import static org.junit.Assert.*; 

import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Failed {

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
		
		 
		//final String URL = "http://stage.iheart.com";
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
		

		/*
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
		 
		 @Test
		 public void testWEB_11785_playStationFromGenreProfile() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11785_playStationFromGenreProfile();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 @Test
		    public void testWEB_11784_signUp() throws Exception
		    {
		    	System.out.println("test method:" +  name.getMethodName() );
		    	try{
			    	   homePage.WEB_11784_signUp();
		    	}catch(Exception e)
			 	{
			 		handleException(e);
			 	} 
			     System.out.println(name.getMethodName() + " is Done.");
		    	
		    }
		 
		 @Test
		 public void testWEB_11758_browseCustomBeforeLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 	   customRadioPage.WEB_11758_browseCustomBeforeLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 @Test
		    public void testWEB_11745_International() throws Exception
		    {   
		    	System.out.println("test method:" +  name.getMethodName() );
		    	try
		    	{
		    	   liveRadioPage.WEB_11745_International();
		    	}catch(Exception e)
		    	{
		    		handleException(e);
		    	}
		    	System.out.println(name.getMethodName() + " is Done.");
		    }
			
		 
		 
		 @Test
		 public void testWEB_11778_pauseResume() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		podcastsPage.WEB_11778_pauseResume();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 
		 @Test  
		 public void testWEB_11749_playStationAfterLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11749_playStationAfterLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 
		 @Test
		 public void testWEB_11755_favorite() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try
	    	{
		 	   liveRadioPage.WEB_11755_favorite();
	    	}catch(Exception e)
	    	{
	    		handleException(e);
	    	}
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 
		 
		 @Test
		 public void testWEB_11743_playLiveWithoutLogin() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11743_playLiveWithoutLogin();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		
		 
		 
		 @Test
		 public void testWEB_11753_favStationAndListenHistoryOnPlayer() throws Exception
		 {   
		 	System.out.println("test method:" +  name.getMethodName() );
		 	try{
		 		liveRadioPage.WEB_11753_favStationAndListenHistoryOnPlayer();
		 	}catch(Exception e)
		 	{
		 		handleException(e);
		 	}  	
		 	System.out.println(name.getMethodName() + " is Done.");
		 }
		 
		 */
		 
		 
	    @After
	    public void tearDown() throws Exception{
	    	driver.quit(); 
	    	if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	
	    	
	    }
	
	    private void handleException(Exception e)
	    {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
            try{
	    	   Page.takeScreenshot(driver, name.getMethodName());
            }catch(Exception eX)
            {
            	
            }
	    }
	    
	    //to handle firefox v37.0 specific issue on windows 7
	    public void closeBrowserSession() throws Exception 
		  { 
		    	
			 Runtime.getRuntime().exec("taskkill /F /IM firefox.exe"); 
		  }
}

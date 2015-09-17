package com.iheart.selenium.webAutomation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

//import org.apache.log4j.Logger;

public class PerfectForPage extends Page{
	
	@FindBy(css="section.section-block:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > button:nth-child(2)")
					private WebElement firstBox;
	
				
	@FindBy(css="section.section-block:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)")
	 	private WebElement firstBoxTitle;
	
	@FindBy(name="activity") private WebElement activity;
	@FindBy(css="li.tile:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > button:nth-child(2)")
	   private WebElement firstBox_activity;
	
	//ThumpUp/Down
	@FindBy(css="button.medium:nth-child(2)") private WebElement thumpUp;
	@FindBy(css="button.medium:nth-child(1)") private WebElement thumpDown;
	@FindBy(css="button.text:nth-child(4)") private WebElement  icon_skip;
	
	//Favorite
	//@FindBy(css=".favorite") private WebElement favorite;
	
	//signup header
	@FindBy(css="div.header:nth-child(1)") private WebElement signupHeader;
	
	public void WEB_11766_browsePerfect()
	{
		//gotoExplorerOption(option_perfectFor, "Perfect");
		comeToThisPage_direct();
	    firstBox.click();
	    makeSureItIsPlaying();
	    
		//Verify sign-up gate shows up
		WaitUtility.sleep(10*1000);
	    if(!isSoftGateShow())
			handleError("Sign up gate is not displayed.", "WEB_11766_browsePerfect");
		
		//driver.navigate().back();
	    
	    comeToThisPage_direct();
		new Select(activity).selectByIndex(3);
		WaitUtility.sleep(1000);
		firstBox_activity.click();
		makeSureItIsPlaying();
		
	  //Verify sign-up gate shows up
		/*
		if(!isSoftGateShow())
  			handleError("Sign up gate is not displayed for filtered activity.", "WEB_11766_browsePerfect");
  		*/	
	}
	
	public void WEB_11769_skipLimit()
	{
		login();
		comeToThisPage_direct();
		
		//First one is my 80s, which is a live station. No skip button will be displayed. 
		//Make sure that a custom station is chosen and played
	    searchBox.clear();
	    searchBox.sendKeys("Classic Rock Garden");
	    WaitUtility.sleep(1000);
	    driver.findElement(By.cssSelector(".selected > div:nth-child(2) > p:nth-child(1) > a:nth-child(1)")).click();
		
		makeSureItIsPlaying();
		
		checkSkipLimit();
	}
	
	
	public void WEB_11768_addToFavorite()
	{
		login();
		//gotoExplorerOption(option_perfectFor, "Perfect");
		comeToThisPage_direct();
		
		//Need to remember this station name
		String chosenStation = firstBoxTitle.getText();
		System.out.println("See chosenStation:" + chosenStation);
	    firstBox.click();
	    makeSureItIsPlaying();
	    
	    doFavorite("WEB_11768_addToFavorite");
	  
		checkFavInProfile(chosenStation);
	}
	
	public void WEB_11770_thumpUpPerfect()
	{
		login();
		//gotoExplorerOption(option_perfectFor, "Perfect");
		comeToThisPage_direct();
		
		//Need to remember this station name
		String chosenStation = firstBoxTitle.getText();
		System.out.println("See chosenStation:" + chosenStation);
	    firstBox.click();
	    makeSureItIsPlaying();
	  
	    doThumbUp("WEB_11770_thumpUpPerfect");
			
	}
	
	public void WEB_11771_pauseResume()
	{
		login();
		perfectFor.click();
		WaitUtility.sleep(500);
		
	   
		driver.findElement(By.cssSelector("li.tile:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > button:nth-child(2)")).click();
		makeSureItIsPlaying();
		
	    
	    //Verify it is playing
	    if (!button_pause.getAttribute("class").contains("playing"))
           handleError("Player is not playing.", "WEB_11771_pauseResume");
	    button_pause.click();
	    if (!button_playing.getAttribute("class").contains("idle"))
	           handleError("Player is not paused.","WEB_11771_pauseResume");
	    button_playing.click();
	    if (!button_pause.getAttribute("class").contains("playing"))
	           handleError("Player is not playing.", "WEB_11771_pauseResume");
		
	}
	
	
	public void WEB_11767_filterAfterLogin()
	{
		login();
		//gotoExplorerOption(option_perfectFor, "Perfect");
		comeToThisPage_direct();
		new Select(activity).selectByIndex(2);
		
		WaitUtility.sleep(1000);
		
		//Need to remember this station name
		String chosenStation = firstBoxTitle.getText();
		System.out.println("See chosenStation:" + chosenStation);
	    firstBox.click();
	    makeSureItIsPlaying();
		
		//verify the player is playing
		//if (!icon_pause.getAttribute("class").equals("icon-pause"))
	    if (!icon_stop.getAttribute("class").equals("icon-stop"))
			handleError("Player is not playing.", "WEB_11767_filterAfterLogin");
	    try{
		   myStations.click();
	    }catch(Exception e)
	    {   //Wait further for pre-roll to finish
	    	WaitUtility.sleep(20000);
	    	 myStations.click();
	    }
		if (!driver.getPageSource().contains(chosenStation))
			handleError("The chosen station is not added to my stations.", "WEB_11767_filterAfterLogin");
		listenHistory.click();
		if (!driver.getPageSource().contains(chosenStation))
			handleError("The chosen station is not added to my listen history.", "WEB_11767_filterAfterLogin");
		
	}
	
	
	
	private void checkSkipLimit()
	{
		//Sometimes pre-roll takes long time to finish
		try{
			icon_skip.getText();
		}catch(Exception e)
		{
			//Give pre-roll more time
			WaitUtility.sleep(5000);
		}
		
		for (int i = 0; i < 6; i++)
		{   
			icon_skip.click();
			thumpDown.click();
			WaitUtility.sleep(200);
		}
		
		icon_skip.click();
		String _growls = growls.getText();
		System.out.println("See growls:" + _growls);
		if (!_growls.contains("reached your skip limit"))
			handleError("Skip limit message is not displayed.", "checkSkipLimit");
		
	}

	public void comeToThisPage()
	{  /* 
		if (isChrome)
			gotoExplorerOption(option_perfectFor_xpath,"Perfect");
		else	
		    gotoExplorerOption(option_perfectFor,"Perfect");
		*/
		
		// if (!driver.getTitle().contains("Perfect"))
		    	comeToThisPage_direct();
	}

	private void comeToThisPage_direct()
	{   String currentURL = driver.getCurrentUrl();
		System.out.println("SEE current url:"  + currentURL);
	    String part1 = currentURL.split("//")[0];
	    String part2  = currentURL.split("//")[1].split("/")[0];
	    
	    String newURL = part1 + "//" + part2 + "/perfect-for/" ;
		System.out.println("SEE new url:"  + newURL );
		
		driver.get(newURL);
		WaitUtility.sleep(1000);
		////WaitUtility.waitForAjax(driver);
	}


}

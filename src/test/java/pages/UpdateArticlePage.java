package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class UpdateArticlePage 
{
	
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	
    WebElement editbutton;
	
    @FindBy(xpath="//input[@placeholder='Article Title']")
    
    WebElement articletitle;
    
    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
    
    WebElement articleabout;
    
    @FindBy(xpath="//textArea[@rows='8']")
    
    WebElement textarea;
    
    @FindBy(xpath="//input[@placeholder='Enter tags']")
    
    WebElement entertag;
    
    @FindBy(xpath="//button[contains(text(),'Update Article')]")
    
    WebElement updatebutton;
    
    @FindBy(xpath="(//a[@href='#/'])[2]")
    
    WebElement homebutton;
    
    @FindBy(xpath="(//button)[2]")
    
    WebElement globalfeed;
    
    @FindBy(xpath = "(//a[@class='author'])[1]")
    
	WebElement profile;


     
     public WebElement articleTitleElement(WebDriver driver,String articletitle)
     
     {
    	 
    	 WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'"+articletitle+"')]"));
    	 
    	 return element;
    	 
     }
     
     public WebElement getUpdateArticleElement(WebDriver driver,String updatedarticletitle)
     
     {
    	 
    	 WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'"+updatedarticletitle+"')]"));
    	 
    	 return element;
    	 
     }
     
     public  UpdateArticlePage(WebDriver driver) 
     
     {
    	 
    	 PageFactory.initElements(driver,this);
    	 
     }
     
     public void homePage() 
     
     {
    	 
    	 homebutton.click();
    	 
    	 globalfeed.click();
    	 
     }
     
	public void update(WebElement element,String title,String about,String text,String tags)
	
	{
		     element.click();
		     
	         editbutton.click();
	         
	    	 articletitle.clear();
	    	 
	    	 articletitle.sendKeys(title);
	    	 
	    	 articleabout.clear();
	    	 
	    	 articleabout.sendKeys(about);
	    	 
	    	 textarea.clear();
	    	 
	    	 textarea.sendKeys(text);
	    	 
	    	 entertag.clear();
	    	 
	    	 entertag.sendKeys(tags);
	    	 
	    	 updatebutton.click();
	    	 
   }
	
	public String updateArticleValidate(WebElement check) 
	
	{
		
		return check.getText();
		
	}
	
	public void profilenavigation()
	
	{
		profile.click();
		
	}
	 	

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class ArticlePageLogIn 
{
	@FindBy(xpath="//a[@href='#/login']")
	
    WebElement loginbutton;
	
    @FindBy(xpath="//input[@name='email']")
    
    WebElement email;
    
    @FindBy(xpath="//input[@name='password']")
    
    WebElement password;
    
    @FindBy(xpath="//button[contains(text(),'Login')]")
    
    WebElement loginbtn;
    
    @FindBy(xpath="//li[contains(text(),'Wrong email/password combination')]")
    
    WebElement invalidlogincheck;
    
    public ArticlePageLogIn(WebDriver driver)
    
    
    {
    	
		PageFactory.initElements(driver,this);
		
	}
    
    public void login()
    
    {
    	
  	  loginbutton.click();
  	  
    }
    
    public WebElement validUserName(WebDriver driver,String username) 
    
    {
        	WebElement element=driver.findElement(By.xpath("//div[contains(text(),'"+username+"')]"));
        	
        	return element;
     }
    
    public void inValidLoginTest(String strmail,String strpassword)
    
    {
    	
  	  email.sendKeys(strmail);
  	  
  	  password.sendKeys(strpassword);
  	  
  	  loginbtn.click();
  	  
  	}
    
    public void validLoginTest(String strmail,String strpassword)
    
    {
           email.clear();
           
   	       email.sendKeys(strmail);
   	       
   	       password.clear();
   	       
    	   password.sendKeys(strpassword);
    	   
    	   loginbtn.click();
    	   
    }
    
   public String checkValidLogin(WebElement element)
   
   {
	   
    	 return element.getText();
    	 
   }
 
   public String checkInValidLogin() 
   
   {
	   
	   return invalidlogincheck.getText();
	   
   }
 

}

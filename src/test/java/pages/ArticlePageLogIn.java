package pages;

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
    
    @FindBy(xpath="//div[contains(text(),'Jai')]")
    
    WebElement validatesuccesslogin;
    
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
    
   public String checkValidLogin()
   
   {
	   
    	 return validatesuccesslogin.getText();
    	 
   }
 
   public String checkInValidLogin() 
   
   {
	   
	   return invalidlogincheck.getText();
	   
   }
 

}

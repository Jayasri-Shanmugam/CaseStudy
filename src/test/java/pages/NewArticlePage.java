package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
 

public class NewArticlePage
{

		    @FindBy(xpath="//a[@href='#/editor']")
		    
		    WebElement newarticlebutton;
		    
		    @FindBy(xpath="//input[@placeholder='Article Title']")
		    
		    WebElement articletitle;
		    
		    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
		    
		    WebElement articleabout;
		    
		    @FindBy(xpath="//textArea[@rows='8']")
		    
		    WebElement textarea;
		    
		    @FindBy(xpath="//input[@placeholder='Enter tags']")
		    
		    WebElement articletags;
		    
		    @FindBy(xpath="//button[@type='submit']")
		    
		    WebElement publisharticlebutton;
		    
		    @FindBy(xpath="//span[contains(text(),'Title already exists.. ')]")
		    
		    WebElement duplicatearticletitle;
		    
	   public NewArticlePage(WebDriver driver) 
	   
	   {
		   
	 		PageFactory.initElements(driver,this);
	 		
	   }
	   
	   public void newArticle() 
	   
	   {
		   
		   newarticlebutton.click();
		   
	   }
	   
	   public void newArticle(String title,String about,String text,String tags) 
	   
	   {
		   
		   articletitle.clear();
		   
		   articletitle.sendKeys(title); 
		   
		   articleabout.clear();
		   
		   articleabout.sendKeys(about);
		   
		   textarea.clear();
		   
		   textarea.sendKeys(text);
		   
		   articletags.clear();
		   
		   articletags.sendKeys(tags);
		   
		   publisharticlebutton.click();
		   
	   }  
	   
	   public WebElement getNewArticleElement(WebDriver driver,String articleTitle) 
	   
	   {
		   
		   WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
		   
	       return element;
	       
	   }
	   
	   public String newArticleValidate(WebElement check) 
	   
	   {
		   
		  return  check.getText();
		  
	   }

	   public String duplicateArticleValidate()
	   
	   {
		   
		   return duplicatearticletitle.getText();
		   
	   }

}

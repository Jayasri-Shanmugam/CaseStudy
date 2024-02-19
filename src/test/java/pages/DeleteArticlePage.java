package pages;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class DeleteArticlePage

{
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='btn btn-sm'][1]")
	
	WebElement deletebutton;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	
	WebElement checkarticle;
	
	@FindBy(xpath="(//a[@href='#/'])[2]")
	
    WebElement homebutton;
	
    @FindBy(xpath="(//button)[2]")
    
    WebElement globalfeed;
    
    @FindBy(xpath = "(//a[@class='author'])[1]")
    
	WebElement profile;



	 public DeleteArticlePage(WebDriver driver)
	 
	 {
		 this.driver=driver;
		 
	 	 PageFactory.initElements(driver,this);
	 	 
	 }
	 
	 public void home() 
	 
	 {
		 
		 homebutton.click();
		 
		 globalfeed.click();
		 
	 }
	 
	 public WebElement delArticleLocate(WebDriver driver,String articletitle) 
	 {
		 
		WebElement articletodelete=driver.findElement(By.xpath("//h1[contains(text(),'"+articletitle+"')]"));
		
		return articletodelete;

	 }
	 
	 public void deleteArticle(WebElement element)
	 
		{
		 
			element.click();
			
		    deletebutton.click();
		    
			Alert alert=driver.switchTo().alert();
			
			alert.accept();
			
		}
	 
	 public String deleteValidate()
	 
	 {
		 
		 return checkarticle.getText();
		 
	 }
	 
	 public void profilenavigation()
		{
			profile.click();
			
		}
 
}

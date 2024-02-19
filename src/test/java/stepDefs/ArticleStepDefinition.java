package stepDefs;

import java.util.List;

import java.util.Map;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
 
import base.TestBase;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import pages.DeleteArticlePage;

import pages.ArticlePageLogIn;

import pages.NewArticlePage;

import pages.UpdateArticlePage;
 

public class ArticleStepDefinition 
{
	 
	
	

		WebDriver driver=TestBase.getDriver();

		ArticlePageLogIn ArticlePagelogin;

		NewArticlePage newArticlePage;

		UpdateArticlePage updateArticlePage;

		DeleteArticlePage deleteArticlePage;

		public ArticleStepDefinition()
		
		{

		    ArticlePagelogin=new ArticlePageLogIn(driver);

			newArticlePage=new  NewArticlePage(driver);

			updateArticlePage=new UpdateArticlePage(driver);

			deleteArticlePage= new  DeleteArticlePage(driver);

		}

		@Given("User is on login Page")

		public void user_is_on_login_page() 
		
		{

		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");

		  ArticlePagelogin.login();

		}

		@When("User enters inValid Credentials")

		public void user_enters_in_valid_credentials(DataTable dataTable) 
		
		{

			List<Map<String,String>> users=dataTable.asMaps();

			String name=users.get(0).get("email");

			String password=users.get(0).get("password");

			ArticlePagelogin.inValidLoginTest(name, password);

		}

		@Then("Should display the invalid login message")

		public void should_display_the_invalid_login_message(DataTable dataTable) 
		
		{
			
			List<String> msgs=dataTable.asList();
			
			String expectedmsg=msgs.get(0);
			
		    Assert.assertEquals(ArticlePagelogin.checkInValidLogin(),expectedmsg);

			

		}

		@When("User enters  valid Credentials")

		public void user_enters_valid_credentials(DataTable dataTable)
		
		{

			List<Map<String,String>> users=dataTable.asMaps();

			String name=users.get(0).get("email");

			String password=users.get(0).get("password");

			ArticlePagelogin.validLoginTest(name, password);

	     }

		@Then("Should display the success login message")

		public void should_display_the_success_login_message(DataTable dataTable) 
		
		{

			List<String> msgs=dataTable.asList();
			String username=msgs.get(0);
			WebElement element=ArticlePagelogin.validUserName(driver,username);
		    Assert.assertEquals(ArticlePagelogin.checkValidLogin(element),username);

		}

		@Given("User is on newArticleCreationPage")

		public void user_is_on_new_article_creation_page() 
		
		{

			newArticlePage.newArticle();

		 }

		@When("User Create the duplicate article")

		public void user_create_the_duplicate_article(DataTable dataTable)
		
		{

			List<Map<String,String>> article=dataTable.asMaps();

			String articletitle=article.get(0).get("articleTitle");

			String  description=article.get(0).get("description");

			String body=article.get(0).get("body");

			String tags=article.get(0).get("tags");

			newArticlePage.newArticle(articletitle,description,body,tags);

		}

		@Then("Should display the duplicate article message")

		public void should_display_the_duplicate_article_message(DataTable dataTable) 
		
		{

			List<String> msgs=dataTable.asList();

			String expectedmsg=msgs.get(0);

		    Assert.assertEquals(newArticlePage.duplicateArticleValidate(),expectedmsg);

		}


		@When("User create the new Article")

		public void user_create_the_new_article(DataTable dataTable)
		
		{

			List<Map<String,String>> article=dataTable.asMaps();

			String articletitle=article.get(0).get("articleTitle");

			String  description=article.get(0).get("description");

			String body=article.get(0).get("body");

			String tags=article.get(0).get("tags");

			newArticlePage.newArticle(articletitle,description,body,tags);

		}

		@Then("Should display the new Article Title")

		public void should_display_the_new_article_title(DataTable dataTable) 
		
		{

			List<String> msgs=dataTable.asList();

			String expectedmsg=msgs.get(0);

			WebElement element=newArticlePage.getNewArticleElement(driver,expectedmsg);

		    Assert.assertEquals(newArticlePage.newArticleValidate(element),expectedmsg);

		}


		@Given("User is on updateArticlePage")

		public void user_is_on_update_article_page() 
		
		{

			updateArticlePage.profilenavigation();

		}

		@When("User Update the Article")

		public void user_update_the_article(DataTable dataTable)
		
		{

			List<Map<String,String>> article=dataTable.asMaps();

			String articletitle=article.get(0).get("articleTitle");

			String updatearticletitle=article.get(0).get("updatedArticleTitle");

			String  description=article.get(0).get("description");

			String body=article.get(0).get("body");

			String tags=article.get(0).get("tags");

			WebElement locatearticletitle=updateArticlePage.articleTitleElement(driver,articletitle);

			updateArticlePage.update(locatearticletitle,updatearticletitle,description,body,tags);


		}

		@Then("Should display the updated Article Title")

		public void should_display_the_updated_article_title(DataTable dataTable) 
		
		{

			List<String> msgs=dataTable.asList();

			String expectedmsg=msgs.get(0);

			WebElement element=updateArticlePage.getUpdateArticleElement(driver, expectedmsg);

			Assert.assertEquals(updateArticlePage.updateArticleValidate(element),expectedmsg);

		}

		@Given("User is on deleteArticlePage")

		public void user_is_on_delete_article_page()
		
		{

			deleteArticlePage.profilenavigation();

		}

		@When("User delete the Article")

		public void user_delete_the_article(DataTable dataTable) 
		
		{

			List<Map<String,String>> article=dataTable.asMaps();

			String deletearticletitle=article.get(0).get("articleName");

			WebElement element=deleteArticlePage.delArticleLocate(driver, deletearticletitle);

		    deleteArticlePage.deleteArticle(element);

		}

		@Then("should the article to be deleted")

		public void should_the_article_to_be_deleted(DataTable dataTable) 
		
		{

			List<String> msgs=dataTable.asList();

			String expectedmsg=msgs.get(0);

			Assert.assertEquals(deleteArticlePage.deleteValidate(),expectedmsg);

		}


	 
	}



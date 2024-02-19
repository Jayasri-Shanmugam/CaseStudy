Feature: Article Page Function
 
Scenario: Invalid Login into app

Given User is on login Page

When User enters inValid Credentials

      |email|password|
      |happymeshri@gmail.com|Jai@2|
      
Then Should display the invalid login message

      |Wrong email/password combination|
 
   
   
Scenario: Valid Login into app

Given User is on login Page

When User enters  valid Credentials

      |email|password|
      |happymeshri@gmail.com|Jai@28|
      
Then Should display the success login message

      |Jai|
 
Scenario: User Create the Article with duplicate Title

Given User is on newArticleCreationPage

When   User Create the duplicate article

       |articleTitle|description|body|tags|
       |Sample|Test|Manual article created|Test|
       
Then   Should display the duplicate article message

       |Title already exists..|
 
Scenario: User Create the new Article

Given User is on newArticleCreationPage

When User create the new Article

       |articleTitle | description | body | tags |
       |Amazon S3 | Simple Storage Service | S3 is a storage service.Objects are stored inside a Bucket.Buckets are containers to store object. |Amazon|
       
Then Should display the new Article Title

       |Amazon S|
 
Scenario: User update the Article

Given User is on updateArticlePage

When User Update the Article

      |articleTitle|updatedArticleTitle|description | body | tags |
      |Amazon S3|Amazon Service|Simple Storage Service|It is a storage service|Test|
      
Then Should display the updated Article Title

      |Amazon Service|
 
Scenario: User delete the Article

Given User is on deleteArticlePage

When User delete the Article

      |articleName|
      |Amazon Service|
      
Then should the article to be deleted

      |Articles not available.|
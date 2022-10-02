@ArticleApi
Feature: Article related actıons can be taken by user as follows:
  * Get Article
  * Create Article
  * Update Article
  * Delete Article

  Background: User needs to be authenticated
    Given User has rights to authenticate

  Scenario: Users wants to create an article
    When User creates their own articles
      | title      | description                       | body                                           | tagList                             |
      | ReThinking | Educate your self with new things | You need to consider every time new approaches | personal, business, self motivation |
    Then User reaches the article

  Scenario: User wants to update article title
    When User updates their own article title
    Then User reaches updated article


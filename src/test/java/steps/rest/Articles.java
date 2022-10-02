package steps.rest;

import client.ArticleHandler;
import client.AuthenticationHandler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.List;

import static client.AuthenticationHandler.sendValidAuthentication;

public class Articles {

    private String token;

    @Given("User has rights to authenticate")
    public void userHasRightsToAuthenticate() {
        sendValidAuthentication();
        token = AuthenticationHandler.getAuthenticationResponse().getUser().getToken();
    }

    @When("User creates their own articles")
    public void userCreatesTheirOwnArticle(DataTable table) {
        ArticleHandler.createArticles(table, token);
    }

    @Then("User reaches the article")
    public void userReachesTheArticle() {
        ArticleHandler.getArticleFromApi();
        Assertions.assertEquals("ReThinking",ArticleHandler.getArticleResponse().getArticle().getTitle());
    }

    @When("User updates their own article title")
    public void userUpdatesTheirOwnArticle() {
        List<String>tagList = new ArrayList<>();
        tagList.add(ArticleHandler.getTagListFromApi().getTags().get(1));
        tagList.add(ArticleHandler.getTagListFromApi().getTags().get(100));
        tagList.add(ArticleHandler.getTagListFromApi().getTags().get(15));
        ArticleHandler.createArticle("Test5","descrpTest5","testbody6",tagList, token);
        ArticleHandler.updateArticleTitle("NEW NEW NEW",token);
    }

    @Then("User reaches updated article")
    public void userReachesUpdatedArticle() {
        ArticleHandler.getArticleFromApi();
        Assertions.assertEquals("NEW NEW NEW",ArticleHandler.getArticleResponse().getArticle().getTitle());
    }

}

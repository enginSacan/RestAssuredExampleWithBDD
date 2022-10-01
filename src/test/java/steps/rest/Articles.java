package steps.rest;

import client.ArticleHandler;
import client.AuthenticationHandler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Article;
import model.AuthenticationResponse;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    }

    @When("User updates their own article")
    public void userUpdatesTheirOwnArticle() {
        System.out.println("A");
    }

    @Then("User reaches updated article")
    public void userReachesUpdatedArticle() {
        System.out.println("A");
    }

    @When("User deletes their own article")
    public void userDeletesTheirOwnArticle() {
        System.out.println("A");
    }

    @Then("User reaches deleted article")
    public void userReachesDeletedArticle() {
        System.out.println("A");
    }

}

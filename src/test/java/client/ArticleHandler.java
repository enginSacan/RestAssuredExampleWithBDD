package client;

import generic.RestProperties;
import io.cucumber.datatable.DataTable;
import lombok.extern.log4j.Log4j2;
import model.*;

import java.util.List;
import java.util.Map;


import static generic.PropertyNames.REST_CREATE_ARTICLE_ENDPOINT;
@Log4j2
public class ArticleHandler {

    public static final String CREATE_ARTICLE = RestProperties.getProperties().getProperty(REST_CREATE_ARTICLE_ENDPOINT);
    private static Article.ArticleBuilder articleBuilder = Article.builder();

    public static void createArticle (String title, String description, String body, List<String> tagList, String token) {
        Article userArticle = Article.builder().title(title).description(description).body(body).tagList(tagList).build();
        CreateArticle requestBody = CreateArticle
                .builder()
                .article(userArticle)
                .build();
        new RestRequestHandler().postWithToken(CREATE_ARTICLE,requestBody,token);
    }
    public static void createArticles (DataTable table, String token) {
        table.asMaps().forEach(ArticleHandler::articleBodyBuilder);
        CreateArticle requestBody = CreateArticle
                .builder()
                .article(articleBuilder.build())
                .build();
        new RestRequestHandler().postWithToken(CREATE_ARTICLE,requestBody,token);
        log.info(getArticleResponse());
    }

    public static ArticleResponse getArticleResponse() {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, ArticleResponse.class);
    }
    public static void getArticleFromApi() {
        new RestRequestHandler().get(CREATE_ARTICLE);
    }
    private static void articleBodyBuilder(Map<String, String> datas) {
        datas.forEach(ArticleHandler::setParameter);
    }
    private static void setParameter(String key, String value) {
        switch (key.toLowerCase()) {
            case "title":
                articleBuilder.title(value);
            case "description":
                articleBuilder.description(value);
            case "body":
                articleBuilder.body(value);
            case "taglist":
                List<String> tagList = List.of(value.split(","));
                articleBuilder.tagList(tagList);
        }
    }
}

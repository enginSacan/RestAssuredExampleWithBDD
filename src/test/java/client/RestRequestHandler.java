package client;

import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.SerializableJson;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.MODULE)
public class RestRequestHandler {
    public static ResponseOptions responseOptions;

    public void post (String requestUrl, SerializableJson requestContent) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .auth()
                .basic("candidatex", "qa-is-cool")
                .headers(getDefaultHeader())
                .body(requestContent.toJson())
                .post();
    }

    public void postWithToken (String requestUrl, SerializableJson requestContent, String jwt) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .auth()
                .basic("candidatex", "qa-is-cool")
                .headers(getHeadersWithToken(jwt))
                .body(requestContent.toJson())
                .post();
    }

    public void get (String requestUrl) {
        RestAssured.baseURI = requestUrl;
        responseOptions = RestAssured
                .given()
                .log().all(true)
                .auth()
                .basic("candidatex", "qa-is-cool")
                .get();
    }
    private Map<String, String> getHeadersWithToken(String jwtToken) {
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("jwtauthorization", "Token "+ jwtToken);
        return headers;
    }
    private Map<String, String> getDefaultHeader() {
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }
}

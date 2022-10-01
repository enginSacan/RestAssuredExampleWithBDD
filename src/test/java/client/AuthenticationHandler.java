package client;

import generic.RestProperties;
import lombok.extern.log4j.Log4j2;
import model.*;

import static generic.PropertyNames.*;
@Log4j2
public class AuthenticationHandler {

    public static final String REST_AUTHENTICATION_ENDPOINT = RestProperties.getProperties().getProperty(REST_AUTH_ENDPOINT);
    public static final String REST_REGISTER_ENDPOINT = RestProperties.getProperties().getProperty(REST_REGIS_ENDPOINT);
    public static final String REST_AUTH_EMAIL = RestProperties.getProperties().getProperty(REST_EMAIL);
    public static final String REST_AUTH_USER = RestProperties.getProperties().getProperty(REST_USERNAME);
    public static final String REST_AUTH_PASSWORD = RestProperties.getProperties().getProperty(REST_PASSWORD);

    public static void sendAuthentication (String email, String password) {
        AuthenticateUser userAuthenticate = AuthenticateUser.builder().email(email).password(password).build();
        AuthenticationRequest requestBody = AuthenticationRequest
                .builder()
                .user(userAuthenticate)
                .build();
        new RestRequestHandler().post(REST_AUTHENTICATION_ENDPOINT,requestBody);
    }

    public static void sendRegistration (String email, String userName,String password) {
        AuthenticateUser userRegister = AuthenticateUser.builder().email(email).username(userName).password(password).build();
        AuthenticationRequest requestBody = AuthenticationRequest
                .builder()
                .user(userRegister)
                .build();
        new RestRequestHandler().post(REST_REGISTER_ENDPOINT,requestBody);
    }
    public static void sendValidAuthentication() {
        sendAuthentication(REST_AUTH_EMAIL,REST_AUTH_PASSWORD);
    }
    public static void sendValidRegistration() {
        sendRegistration(REST_AUTH_EMAIL,REST_AUTH_USER,REST_AUTH_PASSWORD);
    }
    public static RegistrationResponse getRegistrationResponse() {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, RegistrationResponse.class);
    }
    public static AuthenticationResponse getAuthenticationResponse() {
        String jsonString = RestRequestHandler.responseOptions.body().prettyPrint();
        return JsonParser.parseJson(jsonString, AuthenticationResponse.class);
    }
}

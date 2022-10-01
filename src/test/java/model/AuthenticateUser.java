package model;
@lombok.Data
@lombok.Builder
public class AuthenticateUser implements SerializableJson{
    private String username;
    private String email;
    private String password;

}

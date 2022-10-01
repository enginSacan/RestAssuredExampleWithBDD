package model;
@lombok.Data
@lombok.Builder
public class AuthenticationRequest implements SerializableJson{
    private AuthenticateUser user;
}

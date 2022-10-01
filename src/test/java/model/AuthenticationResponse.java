package model;
@lombok.Data
@lombok.Builder
public class AuthenticationResponse implements SerializableJson{
    private ResponseUser user;
}

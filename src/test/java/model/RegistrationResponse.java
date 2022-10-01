package model;
@lombok.Data
@lombok.Builder
public class RegistrationResponse implements SerializableJson{
    private ResponseUser user;
}

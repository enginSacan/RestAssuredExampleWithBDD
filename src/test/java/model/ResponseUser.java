package model;
@lombok.Data
@lombok.Builder
public class ResponseUser implements SerializableJson{
    private  String email;
    private  String token;
    private  String username;
    private  String bio;
    private  String image;
}

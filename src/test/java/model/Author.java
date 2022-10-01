package model;
@lombok.Data
@lombok.Builder
public class Author implements SerializableJson{
    private String username;
    private String bio;
    private String image;
    private Boolean following;

}

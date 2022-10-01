package model;
@lombok.Data
@lombok.Builder
public class CreateArticle implements SerializableJson{
    private Article article;
}

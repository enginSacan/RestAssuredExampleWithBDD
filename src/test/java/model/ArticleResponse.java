package model;
@lombok.Data
@lombok.Builder
public class ArticleResponse implements SerializableJson{
    private ArticleResponseBody article;
}

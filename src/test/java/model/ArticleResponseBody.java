package model;

import java.util.List;
@lombok.Data
@lombok.Builder
public class ArticleResponseBody implements SerializableJson{
        private String slug;
        private String title;
        private String description;
        private String body;
        private List<String> tagList;
        private String createdAt;
        private String updatedAt;
        private Boolean favorited;
        private int favoritesCount;
        private Author author;

}

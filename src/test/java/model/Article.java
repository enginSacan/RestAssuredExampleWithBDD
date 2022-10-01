package model;

import java.util.List;
@lombok.Data
@lombok.Builder
public class Article implements SerializableJson{
    private String title;
    private String description;
    private String body;
    private List<String> tagList;

}

package model;

import java.util.List;
@lombok.Data
@lombok.Builder
public class TagList implements SerializableJson{
    List<String> tags;
}

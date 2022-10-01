package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface SerializableJson {

    default String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}

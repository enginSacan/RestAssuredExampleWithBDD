package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {

    public static <T> T parseJson (String jsonString, Class<T> destinationClass) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString,destinationClass);
    }
}

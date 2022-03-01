package edu.cascadia.mobas.campusguidebook.data.typeconverter;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class PropertyListTypeConverter {
    private static final Gson sGson = new Gson();

    @TypeConverter
    public static String toJson(@Nullable Map<String, String> properties) {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return sGson.toJson(properties);
    }

    @TypeConverter
    public static Map<String, String> toMap(@Nullable String json) {
        return jsonStrToMap(json);
    }

    public static <T> Map<String, T> jsonStrToMap(String jsonStr) {
        Type type = new TypeToken<Map<String, T>>() {}.getType();
        return sGson.fromJson(jsonStr, type);
    }
}
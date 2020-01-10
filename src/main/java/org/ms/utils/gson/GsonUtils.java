package org.ms.utils.gson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public final class GsonUtils {

    private GsonUtils(){}

    private static final Gson gson = new Gson();

    public static final Gson getGson() {
        return gson;
    }

    public static final String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static final <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }

}


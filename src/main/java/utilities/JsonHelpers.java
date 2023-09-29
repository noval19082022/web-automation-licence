package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonHelpers {
    private static Gson gson = new Gson();
    private static JsonElement jsonElement;

    /**
     * Create JSON file from JSON string
     * @param jsonString JSON string
     * @param path Path to JSON file
     */
    public static void createJsonFileFromJsonString(String jsonString, String path) {
        try {
            // Parse JSON string to JSON object
            ObjectMapper objectMapper = new ObjectMapper();
            Object json = objectMapper.readValue(jsonString, Object.class);

            // Write JSON object to file
            File outputFile = new File(path);
            objectMapper.writeValue(outputFile, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create JSON string from Map
     * @param map Map
     * @return JSON string
     */
    public static String createJsonStringFromMap(Map<Object, Object> map) {
        return gson.toJson(map);
    }

    /**
     * Create JSON Element from JSON file
     * @param jsonFilePath path to JSON file
     * @return JsonElement
     */
    public static JsonElement createJsonElementFromJsonFile(String jsonFilePath) {
        try {
            jsonElement = JsonParser.parseReader(new FileReader(jsonFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonElement;
    }

    /**
     * Create JSON Object from JSON Element
     * @param jsonElement
     * @return JsonObject
     */
    public static JsonObject createJsonObject(JsonElement jsonElement) {
        return jsonElement.getAsJsonObject();
    }

    public static JsonObject createJsonObject(JsonElement jsonElement, String key) {
        return jsonElement.getAsJsonObject().get(key).getAsJsonObject();
    }

    /**
     * Create JSON Array from JSON Object
     * @param jsonObject JSON Object
     * @param key JSON key
     * @return JsonArray
     */
    public static JsonArray createJsonArray(JsonObject jsonObject, String key) {
        return jsonObject.getAsJsonArray(key);
    }

    public static String getJsonObjectValueAsString(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsString();
    }

    public static int getJsonObjectValueAsInt(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsInt();
    }

    public static boolean getJsonObjectValueAsBoolean(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsBoolean();
    }
}

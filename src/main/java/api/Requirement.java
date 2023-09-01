package api;

import data.api.CreateDeviceId;
import data.mamikos.ApiEndpoints;
import utilities.JavaHelpers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Requirement {
    private static Map<String, String> headers = new HashMap<>();

    /**
     * Create signature key for mamikos api Authorization header
     * @param method GET, POST, PUT, DELETE
     * @param path api endpoint
     * @return signature key
     * @throws NoSuchAlgorithmException if hmac sha256 algorithm not found
     * @throws InvalidKeyException if secret key is invalid
     */
    public static String createSignatureKey(String method, String path) throws NoSuchAlgorithmException, InvalidKeyException {
        var data = method.toUpperCase() + " " + path + " " +  ApiEndpoints.X_GIT_TIME;
        return JavaHelpers.bytesToHexString(JavaHelpers.generateHmacSha256(ApiEndpoints.SECRET_KEY, data));
    }

    /**
     * Create standard headers for mamikos api
     * @param signature signature key
     * @return headers map
     */
    public static Map<String, String> mamikosStandardHeaders(String signature) {
        headers.put("Authorization", "GIT "+ signature + ":" + CreateDeviceId.getDeviceToken());
        headers.put("X-GIT-Time", ApiEndpoints.X_GIT_TIME);
        headers.put("Content-Type", "application/json");
        return headers;
    }
}

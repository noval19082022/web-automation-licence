package data.api;

import lombok.Getter;
import lombok.Setter;

public class CreateDeviceId {
    @Setter @Getter
    private static String phoneNumber, deviceIdentifier, deviceUuid, devicePlatform, deviceToken, deviceId;
}

package data.api;

import lombok.*;

public class UserCookies {
    @Getter
    @Setter
    private static String tenantCookie, ownerCookie;
}

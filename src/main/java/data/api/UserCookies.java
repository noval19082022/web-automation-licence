package data.api;

import lombok.Getter;
import lombok.Setter;

public class UserCookies {
    @Getter @Setter
    private static String tenantCookie, ownerCookie;
}

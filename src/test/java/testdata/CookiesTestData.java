package testdata;

import com.microsoft.playwright.options.Cookie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CookiesTestData {
    @Setter @Getter
    private static List<Cookie> cookies;
}
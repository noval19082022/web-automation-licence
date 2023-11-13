package testdata;

import lombok.Getter;
import lombok.Setter;

public class BangKrupuxTestData {
    private static String kostName;
    @Setter @Getter
    private static String ownerRoomGroup;
    @Setter @Getter
    private static String ownerRoomGroupUntil;
    private static String urlDeleteKos;

    public static void setKostName(String kostName) {
        BangKrupuxTestData.kostName = kostName;
    }

    public static String getKostName() {
        return BangKrupuxTestData.kostName;
    }

    public static void hrefDeleteKosUrl(String kosListDeleteUrl) {
        BangKrupuxTestData.urlDeleteKos = kosListDeleteUrl;
    }
}

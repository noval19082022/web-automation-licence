package testdata;

import lombok.Getter;
import lombok.Setter;

public class BangKrupuxTestData {
    private static String kostName;
    @Setter @Getter
    private static String ownerRoomGroup;
    @Setter @Getter
    private static String ownerRoomGroupUntil;

    public static void setKostName(String kostName) {
        BangKrupuxTestData.kostName = kostName;
    }

    public static String getKostName() {
        return BangKrupuxTestData.kostName;
    }
}

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
    private static String urlRejectKos;
    private static String urlApproveKos;

    public static void setKostName(String kostName) {
        BangKrupuxTestData.kostName = kostName;
    }

    public static String getKostName() {
        return BangKrupuxTestData.kostName;
    }

    public static void hrefDeleteKosUrl(String kosListDeleteUrl) {
        BangKrupuxTestData.urlDeleteKos = kosListDeleteUrl;
    }

    public static void hrefApproveKosUrl(String kosListApproveUrl) {
        BangKrupuxTestData.urlApproveKos = kosListApproveUrl;
    }

    public  static void hrefRejectKostUrl(String kosListRejectUrl){
        BangKrupuxTestData.urlRejectKos = kosListRejectUrl;
    }

    public static String getUrlDeleteKos() {
        return urlDeleteKos;
    }

    public static void setUrlDeleteKos(String urlDeleteKos) {
        BangKrupuxTestData.urlDeleteKos = urlDeleteKos;
    }

    public static String getUrlRejectKos() {
        return urlRejectKos;
    }

    public static void setUrlRejectKos(String urlRejectKos) {
        BangKrupuxTestData.urlRejectKos = urlRejectKos;
    }

    public static String getUrlApproveKos() {
        return urlApproveKos;
    }

    public static void setUrlApproveKos(String urlApproveKos) {
        BangKrupuxTestData.urlApproveKos = urlApproveKos;
    }
}

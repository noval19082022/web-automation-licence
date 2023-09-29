package data.api;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AcceptBooking {
    @Setter @Getter
    private static String name,
        phoneNumber,
        gender,
        email,
        occupation,
        startDate,
        rentType,
        parentName,
        parentPhoneNumber,
        fineDurationType,
        existingTenant,
        dpDate,
        dpSettlementDate;
    @Setter @Getter
    private static Integer roomId,
        roomNumber,
        amount,
        duration,
        photoId,
        photoIdentifierId,
        photoDocumentId,
        firstAmount,
        depositAmount,
        fineAmount,
        dpAmount,
        designerRoomId,
        billingDate,
        fineMaximumLength;

    @Setter @Getter
    private static List<Object> additionalCosts;

    @Setter @Getter
    private static List<Map<String, String>> question = new ArrayList<>();

    @Setter @Getter
    private static boolean ownerAccept, saveCostGroup, useDp, fixedBilling;

    @Setter @Getter
    private static Object maritalStatus;

    /**
     * Set rent type duration
     * @param rentTypeDurationIndonesia rent type duration in Indonesian
     * @return rent type duration in English as String
     */
    public static String rentType (String rentTypeDurationIndonesia) {
        switch (rentTypeDurationIndonesia) {
            case "Hari":
                return "day";
            case "Minggu":
                return "week";
            case "Bulan":
                return "month";
            case "Tahun":
                return "year";
            default:
                return "month";
        }
    }
}

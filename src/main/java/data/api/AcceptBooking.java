package data.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
        fineMaximumLength,
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
        billingDate;

    @Setter @Getter
    private static List<Object> question, additionalCosts;

    @Setter @Getter
    private static boolean ownerAccept, saveCostGroup, useDp, maritalStatus, fixedBilling;
}

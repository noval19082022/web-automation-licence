package data.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AcceptBooking {
    @Setter @Getter
    private String name,
        phoneNumber,
        gender,
        email,
        occupation,
        maritalStatus,
        startDate,
        rentType,
        parentPhoneNumber,
        fixedBilling,
        billingDate,
        fineMaximumLength,
        existingTenant,
        dpAmount;
    @Setter @Getter
    private int roomNumber,
        amount,
        duration,
        photoId,
        photoIdentifierId,
        photoDocumentId,
        firstAmount,
        depositAmount,
        fineAmount,
        dpSettlementDate;

    @Setter @Getter
    private List<Object> question, additionalCosts;

    @Setter @Getter
    private boolean ownerAccept, saveCostGroup, useDp, designerRoomId;
}

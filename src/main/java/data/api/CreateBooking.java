package data.api;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class CreateBooking {
    @Setter @Getter
    private static String
            rentCountType,
            checkIn,
            checkOut,
            contactName,
            contactJob,
            contactGender,
            contactIdentity,
            contactIntroduction,
            contactWorkPlace,
            firstPaymentType,
            sessionId,
            tenantProfileResponse;

    @Setter @Getter
    private static int duration,
            marriageBookId,
            familyCardId,
            photoSelfieId,
            photoIdentityId,
            totalRenter;

    @Setter @Getter
    private static boolean
            isFlashSale,
            isMarried,
            isBringChild,
            isDownPaymentActive;

    @Setter @Getter
    private static Object contactPhone;

    @Setter @Getter
    private static Map<Object, Object> createBookingBody = new HashMap<>();
}

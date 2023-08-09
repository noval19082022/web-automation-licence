package data.api;

import lombok.*;

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
            sessionId;

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
            isBringChild;

    @Setter @Getter
    private static long contactPhone;

    @Setter @Getter
    private static Map<Object, Object> createBookingBody = new HashMap<>();
}

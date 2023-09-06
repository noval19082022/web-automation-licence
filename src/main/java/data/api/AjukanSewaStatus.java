package data.api;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class AjukanSewaStatus {
    /**
     * This class is used to store the status of the booking process.
     * booked = tunggu konfirmasi
     * confirmed = butuh pembayaran
     * verified = pembayaran berhasil dp atau full
     */
    @Setter @Getter
    private static List<String> booked, confirmed, verified, checkedIn;
}

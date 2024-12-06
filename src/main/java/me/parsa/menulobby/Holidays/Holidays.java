package me.parsa.menulobby.Holidays;

import java.time.LocalDate;

public class Holidays {

    public enum SpecialEvent {
        CHRISTMAS,
        HALLOWEEN,
        NONE
    }

    public static SpecialEvent getCurrentEvent() {
        LocalDate today = LocalDate.now();


        if (today.getMonthValue() == 12 && today.getDayOfMonth() >= 20 && today.getDayOfMonth() <= 26) {
            return SpecialEvent.CHRISTMAS;
        }


        if (today.getMonthValue() == 10 && today.getDayOfMonth() >= 25 && today.getDayOfMonth() <= 31) {
            return SpecialEvent.HALLOWEEN;
        }


        return SpecialEvent.NONE;
    }
}

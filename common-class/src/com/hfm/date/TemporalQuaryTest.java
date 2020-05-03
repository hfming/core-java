package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

/**
 * @author hfm
 * @version 1.01 2020-04-16 0:06
 * @date 2020/4/16
 */
public class TemporalQuaryTest {
    @Test
    public void temporalQuaryTes() {
        Long query = LocalDateTime.now().query((TemporalAccessor temporalAccessor) -> {
            LocalDate localDate = LocalDate.from(temporalAccessor);
            LocalDate dateTime = LocalDate.of(localDate.getYear(), Month.MARCH, 1);
            if (localDate.isAfter(dateTime)) {
                dateTime = localDate.plusYears(1);
            }
            return ChronoUnit.DAYS.between(localDate, dateTime);
        });
        System.out.println(query);
    }
}

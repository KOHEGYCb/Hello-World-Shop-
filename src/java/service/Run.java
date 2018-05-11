package service;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 *
 * @author dmitry
 */
public class Run {
    public static void main(String[] args) {
        
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(date.getTime());
        
    }
}

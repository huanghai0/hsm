package timeformatter;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateFormatter {

    private final static DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM");
    private final static DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public Long getTimeLong(Object obj) {
        Long time = 0L;

        if (obj == null || "".equals(obj)) return time;

//        LocalDateTime dateTime = LocalDateTime.parse(obj.toString(),dateFormatter1);
        Object o = dateFormatter1.parse("2021-01");
        System.out.println("---");

        return time;
    }

    public static void main(String[] args) {

//        LocalDate localDate = LocalDate.parse("2021-02-03", dateFormatter2);
//        LocalDateTime localDateTime = LocalDateTime.parse("2021-01-02 22:04:23:078", dateFormatter3);
//        String str = localDateTime.format(dateFormatter2);
//        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
//        Instant instant = zonedDateTime.toInstant();
//
//        Long l = instant.getEpochSecond();
//
        Long ltime = LocalDateTime.parse("2021-01-02 00:00:00:000", dateFormatter3).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//
        Long ld = (new Date()).getTime();
        System.out.println(ltime);
        System.out.println(ld);
        System.out.println(ltime - ld);

        Map<String, Object> map = new HashMap<>();


        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime localDateTime = LocalDateTime.parse("2019-07-31 00:00:00", dateTimeFormatter1);
        LocalDate localDate = LocalDate.parse("2021-01-02", dateTimeFormatter2);
        Date date = Date.from(LocalDateTime.parse("2019-07-31 00:00:00", dateTimeFormatter1).atZone(ZoneId.systemDefault()).toInstant());
        Long ldate = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(ldate);

        String strDateTime = "2019-07-31 00:00:00";
        String strDate = "2019-07-31";
        Long timestamp = 1564502400000l;

/** LocalDateTime ??? LocalDate */
        System.out.println("LocalDateTime ??? LocalDate: " + localDateTime.toLocalDate());
/** LocalDateTime ??? Long */
        System.out.println("LocalDateTime ??? Long: " + localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
/** LocalDateTime ??? Date */
        System.out.println("LocalDateTime ??? Date: " + Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
/** LocalDateTime ??? String */
        System.out.println("LocalDateTime ??? String: " + localDateTime.format(dateTimeFormatter1));

        System.out.println("-------------------------------");

/** LocalDate ??? LocalDateTime */
        System.out.println("LocalDate ??? LocalDateTime: " + LocalDateTime.of(localDate, LocalTime.parse("00:00:00")));
/** LocalDate ??? Long */
        System.out.println("LocalDate ??? Long: " + localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
/** LocalDate ??? Date */
        System.out.println("LocalDate ??? Date: " + Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
/** LocalDate ??? String */
        System.out.println("LocalDateTime ??? String: " + localDateTime.format(dateTimeFormatter2));

        System.out.println("-------------------------------");

/** Date ??? LocalDateTime */
        System.out.println("Date ??? LocalDateTime: " + LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
/** Date ??? Long */
        System.out.println("Date ??? Long: " + date.getTime());
/** Date ??? LocalDate */
        System.out.println("Date ??? LocalDateTime: " + LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate());
/** Date ??? String */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("Date ??? String: " + sdf.format(date));

        System.out.println("-------------------------------");

/** String ??? LocalDateTime */
        System.out.println("String ??? LocalDateTime: " + LocalDateTime.parse(strDateTime, dateTimeFormatter1));
/** String ??? LocalDate */
        System.out.println("String ??? LocalDate: " + LocalDateTime.parse(strDateTime, dateTimeFormatter1).toLocalDate());
        System.out.println("String ??? LocalDate: " + LocalDate.parse(strDate, dateTimeFormatter2));
/** String ??? Date */
        System.out.println("String ??? Date: " + Date.from(LocalDateTime.parse(strDateTime, dateTimeFormatter1).atZone(ZoneId.systemDefault()).toInstant()));

        System.out.println("-------------------------------");

/** Long ??? LocalDateTime */
        System.out.println("Long ??? LocalDateTime:" + LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
/** Long ??? LocalDate */
        System.out.println("Long ??? LocalDate:" + LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()).toLocalDate());

        System.out.println("---");
    }
}

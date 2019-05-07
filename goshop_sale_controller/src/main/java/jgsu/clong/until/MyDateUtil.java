package jgsu.clong.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtil {
    public static Date getMyDate(int i) {
        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, i);

        return c.getTime();
    }

    public static String getMyDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

        String format = sdf.format(new Date());
        return format;
    }
}

package top.xinsin.util;

import java.util.Date;

public class TimeUtils {
    public static long toTimestamp(Date time){
            long stamp = 0;
            stamp = time.getTime();
            return stamp;
    }
}

package io.github.liuwang.magicoder.utils;

/**
 * Created by LiuWang on 12/08/2016.
 */
public class TimeUtil {
    /**
     * @param publishedAt
     * @return
     * 将2015-08-06T07:15:52.65Z 截取为2015-08-06
     */
    public static String splitPublishedAt(String publishedAt){
        return publishedAt.split("T")[0];
    }
}

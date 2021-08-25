package top.xinsin.util;

import java.lang.Math;

public class CalculateUtils {
    public static double plus(double n1,double n2){
        return n1 + n2;
    }
    public static double minus(double n1,double n2){
        return n1 - n2;
    }
    public static double multiply(double n1,double n2){
        return n1 * n2;
    }
    public static double divide(double n1,double n2){
        return n1 / n2;
    }
    public static String to(String num,Integer scale,Integer newscale){
        return Integer.toString(Integer.valueOf(num,scale),newscale);
    }
    public static double sin(double x){
            return Math.sin(x);
    }
}

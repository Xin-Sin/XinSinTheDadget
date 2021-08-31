package top.xinsin.test;

import java.util.Arrays;

import static top.xinsin.util.Calculate.*;

public class MainTest {
    private static long testseed = 123456789L;
    public static void main(String[] args) {
//        System.out.println(getI(testseed));
//        System.out.println(getJ(testseed));
        System.out.println(Arrays.toString(chunkDiamond(testseed, 1, 1)));
    }
}

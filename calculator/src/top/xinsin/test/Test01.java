package top.xinsin.test;

import java.util.Random;

/**
 * 有大约10万个数字，每个数字大小在30左右,求他们的乘积。
 * 要求：
 *  1.运行堆内存只有4M（-Xmx4m）
 *  2.耗时小于2秒
 * 输入：数字数组
 * 输出: 这些数字的乘积
 */
public class Test01 {
    public static void main(String[] args) {
        final Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int k = random.nextInt(30);
            for (int j = 0; j < 100000 - i; j++) {
                int l = random.nextInt(30);
                System.out.println(k * l);
            }
        }
    }
}

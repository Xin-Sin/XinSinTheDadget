package top.xinsin.util;

import java.util.ArrayList;

public final class Calculate {
    private static  String [] strings = new String[2];
    private static final ArrayList arrayList = new ArrayList();
    private static final long [] longs = new long[2];
    private static final long mul = 25214903917L;
    private static final long mask = (1L << 48) - 1;
    private static long a = 0, b = 0,c = 0,d = 0,e = 0,i = 0,j = 0,g = 0,h = 0;

    /**
     * 1.16.5多区块计算
     * @param seed 种子
     * @param X X范围
     * @param Z Z范围
     * @return 返回钻石位置
     */
    public static final ArrayList allChunkDiamondSix(long seed,long X,long Z){
        arrayList.clear();
        for (int k = 0; k < X; k++) {
            for (int l = 0; l < Z; l++) {
                strings = chunkDiamondSix(seed,k,l);
                arrayList.add("[" + "X = " + strings[0]);
                arrayList.add("Y = " + strings[1] + "]" + "\n");
            }
        }
        return arrayList;
    }
    /**
     * 1.17.1多区块计算
     * @param seed 种子
     * @param X X范围
     * @param Z Z范围
     * @return 返回钻石位置
     */
    public static final ArrayList allChunkDiamondSeven(long seed,long X,long Z){
        arrayList.clear();
        for (int k = 0; k < X; k++) {
            for (int l = 0; l < Z; l++) {
                strings = chunkDiamondSeven(seed,k,l);
                arrayList.add("[" + "X = " + strings[0]);
                arrayList.add("Y = " + strings[1] + "]" + "\n");
            }
        }
        return arrayList;
    }
    /**
     * 1.16.5获取钻石位置
     * @param seed 种子号
     * @param chunkX 区块X坐标
     * @param chunkZ 区块Z坐标
     * @return 钻石坐标 strings[0] = X坐标,strings[1] = Z坐标
     */
    public static final String[] chunkDiamondSix(long seed,long chunkX,long chunkZ){
        long[] longs1 = getRelatively(getTemporary(seed, chunkX, chunkZ) + 60009);
        strings[0] = String.valueOf(longs1[0] + 16 * chunkX);
        strings[1] = String.valueOf(longs1[1] + 16 * chunkZ);
        return strings;
    }
    /**
     * 1.17.1获取钻石位置
     * @param seed 种子号
     * @param chunkX 区块X坐标
     * @param chunkZ 区块Z坐标
     * @return 钻石坐标 strings[0] = X坐标,strings[1] = Z坐标
     */
    public static final String[] chunkDiamondSeven(long seed,long chunkX,long chunkZ){
        long[] longs1 = getRelatively(getTemporary(seed, chunkX, chunkZ) + 60011);
        strings[0] = String.valueOf(longs1[0] + 16 * chunkX);
        strings[1] = String.valueOf(longs1[1] + 16 * chunkZ);
        return strings;
    }
    /**
     * 获取相对坐标
     * @param temporary 临时变量
     * @return 返回相对坐标的数组 long[0] = X,long[1] = Y
     */
    public static final long[] getRelatively(long temporary){
        temporary = temporary ^ mul & mask;
        g = (temporary * mul + 11) & mask;
        h = (g * mul + 11) & mask;
        longs[0] = g >> 44;
        longs[1] = h >> 44;
        return longs;
    }
    /**
     * 获取临时变量
     * @param seed 种子号
     * @param chunkX 区块X坐标
     * @param chunkZ 区块Z坐标
     * @return  返回时临时变量
     */
    public static final long getTemporary(long seed,long chunkX,long chunkZ){
        a = seed ^ mul & mask;
        b = (a * mul + 11) & mask;
        c = (b * mul + 11) & mask;
        d = (c * mul + 11) & mask;
        e = (d * mul + 11) & mask;
        i = (((b >> 16) << 32) + ((c <<16) >> 32) ) | 1;
        j = (((d >> 16) << 32) + ((e << 16) >> 32) ) | 1;
        return (((16 * chunkX * i + 16 * chunkZ * j) ^ seed));
    }
}

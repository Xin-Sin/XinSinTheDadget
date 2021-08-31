package top.xinsin.util;

public final class Calculate {
    private static final long mul = 25214903917L;
    private static final long mask = (1L << 48) - 1;
    public static final String[] chunkDiamond(long seed,long chunkX,long chunkZ){
        String [] strings = new String[2];
        long a = seed ^ mul & mask;
        long b = 0,c = 0,d = 0,e = 0,i = 0,j = 0,f = 0,g = 0 ,h = 0;
        b = (a * mul + 11) & mask;
        c = (b * mul + 11) & mask;
        i = (((b >> 16) << 32) + ((c <<16) >> 32) ) | 1;
        d = (c * mul + 11) & mask;
        e = (d * mul + 11) & mask;
        j = (((d >> 16) << 32) + ((e << 16) >> 32) ) | 1;
        System.out.println(i);
        System.out.println(j);
        f = (16 * chunkX * i + 16 * chunkZ * j) ^ seed + 60009;
        System.out.println(f ^ mul & mask);
        g = (f * mul + 11) & mask;
        System.out.println(g);
        return strings;
    }
    /*public static final long getI(long seed){
        long i = 0;
        long tmp = seed ^ mul & mask;
        tmp = (tmp * mul + 11) & mask >> 16 << 32;
        tmp = (tmp * mul + 11) & mask << 16 >> 32;
        i = tmp | 1;
        return i;
    }
    public static final long getJ(long seed){
        long j = 0;
        long i = getI(seed);
        long tmp = i;
        tmp = (tmp * mul + 11) & mask >> 16 << 32;
        tmp = (tmp * mul + 11) & mask << 16 >> 32;
        j = tmp | 1;
        return j;
    }
    public static final String[] chunkDiamond(long seed,long chunkX,long chunkZ){
        String[] R = new String[2];
        final long a = seed ^ mul & mask;
        long i = getI(seed);
        long j = getJ(seed);
        long tmp1 = (((((((i*16) + (32*j)) ^ seed + 60009) ^ mul) & mask) * mul) + 11 )& mask;
        long tmp2 = (tmp1 * mul + 11) & mask;
        long x = chunkX * 16 + (tmp1 >> 44);
        long z = chunkZ * 16 + (tmp2 >> 44);
        R[0] = String.valueOf(x);
        R[1] = String.valueOf(z);
        return R;
    }
    public static final String[] AllDiamond(long seed){
        String[] R = new String[]{};
        int tmp = 0;
        for(int cx = 0;cx < 100;cx++){
            for(int cy = 0;cy < 100;cy++){
                for (String s : chunkDiamond(seed, cx, cy)) {
                    R[tmp] = s;
                    tmp ++;        
                }
            }
        }
        return R;
    }*/
}

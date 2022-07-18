package com.sxt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    //方向
    static boolean UP =false;
    static boolean DOWN =false;
    static boolean LEFT =false;
    static boolean RIGHT =false;

    //分数
    static int count = 60;

    //关卡等级
    static int level = 0;

    //敌方鱼类集合
    public static List<Enamy> EnamyList = new ArrayList<>();


    //背景图
    public static Image bgimg = Toolkit.getDefaultToolkit().createImage("images/sea.jpg");

    //敌方鱼类
    public static Image enamy1_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_r.gif");
    public static Image enamyr_img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish1_l.gif");
    public static Image enamyl_2img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_r.png");
    public static Image enamyr_2img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish2_l.png");
    public static Image enamyl_3img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_r.png");
    public static Image enamyr_3img = Toolkit.getDefaultToolkit().createImage("images/enemyFish/fish3_l.png");
    public static Image bossimg = Toolkit.getDefaultToolkit().createImage("images/enemyFish/boss.gif");
    //我方鱼类
    public static Image MyFishimg_L = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_left.gif");
    public static Image MyFishimg_R = Toolkit.getDefaultToolkit().createImage("images/myFish/myfish_right.gif");




    //绘制文字的工具类
    public static void drawWord(Graphics g,String str ,Color color,int size,int x, int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str, x, y);
    }

}

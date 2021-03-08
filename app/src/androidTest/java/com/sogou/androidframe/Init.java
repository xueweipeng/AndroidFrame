package com.sogou.androidframe;

/**
 * created by weapon on 2021/3/3
 * 输出顺序3，4，2，3，4
 */
public class Init {
    private static final String TAG = "InitTest";
    public static int a = 1;
    public static Init obj = new Init();

    static {
        a = 2;
        System.out.println(2);
    }

    private int n = 5;

    {
        a = 3;
        System.out.println(3);
    }

    public Init() {
        a = 4;
        System.out.println(4);
    }

    public static void main(String[] args) {
        new Init();
    }

    private void fun() {

    }

    class Inner {
        public void getParent() {
            n = 6;
            fun();
        }
    }
}


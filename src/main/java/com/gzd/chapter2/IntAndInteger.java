package com.gzd.chapter2;

/**
 * @author gzd
 * @date 2019/7/28 下午3:04
 */
public class IntAndInteger {

    public static void main(String[] args) {
        //Long sum = 0L;
        // 基本类型;
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum +=i;
        }
        System.out.println("用时："+ (System.currentTimeMillis() - start));
    }
}

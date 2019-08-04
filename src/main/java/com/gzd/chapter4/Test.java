package com.gzd.chapter4;

import com.sun.tools.javac.util.List;

import java.util.HashSet;

/**
 * @author gzd
 * @date 2019/8/4 下午3:56
 */
public class Test {

    public static void main(String[] args) {
        // 继承测试代码
        /*ObjectExtends objectExtends = new ObjectExtends(10);
        objectExtends.addAll(List.of("123","234","345"));
        System.out.println(objectExtends.getAddCount());*/
        // 复用测试代码
        ObjectExtendsNew objectExtendsNew = new ObjectExtendsNew(new HashSet());
        objectExtendsNew.addAll(List.of("213","123","321"));
        System.out.println(objectExtendsNew.getAddCount());
    }


}

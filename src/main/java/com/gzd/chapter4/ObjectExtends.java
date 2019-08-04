package com.gzd.chapter4;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author gzd
 * @date 2019/8/4 下午3:49
 * 条目18 复合优先于继承
 */
public class ObjectExtends<T> extends HashSet<T> {

    public int addCount;

    public ObjectExtends(int cap){
        super(cap);
    }
    @Override
    public boolean add(T t){
        addCount += 1;
        return super.add(t);
    }
    @Override
    public boolean addAll(Collection<? extends  T> s){
        addCount += s.size();
        return super.addAll(s);
    }

    public int getAddCount(){
        return addCount;
    }


}

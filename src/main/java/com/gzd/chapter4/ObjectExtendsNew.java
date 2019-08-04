package com.gzd.chapter4;

import java.util.Collection;
import java.util.Set;

/**
 * @author gzd
 * @date 2019/8/4 下午3:58
 */
public class ObjectExtendsNew<E>  extends ForwardSet<E>{

    public int addCount;

    public ObjectExtendsNew(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e){
        addCount += 1;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

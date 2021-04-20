package com.heedi.spring.inheritance;

import java.util.Collection;
import java.util.HashSet;

public class BadChildHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public BadChildHashSet() {
    }

    public BadChildHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

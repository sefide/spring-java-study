package com.heedi.spring.inheritance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BadChildHashSetTest {

    @Test
    void add_test() {
        BadChildHashSet<Character> badChildHashSet = new BadChildHashSet<>();

        badChildHashSet.add('N');
        assertEquals(1, badChildHashSet.getAddCount());

        badChildHashSet.add('B');
        assertEquals(2, badChildHashSet.getAddCount());

        badChildHashSet.add('B');
        assertEquals(3, badChildHashSet.getAddCount());

        badChildHashSet.add('A');
        assertEquals(4, badChildHashSet.getAddCount());
        assertEquals(3, badChildHashSet.size());
    }

    @Test
    void addAll_test() {
        BadChildHashSet<Character> badChildHashSet = new BadChildHashSet<>();

        badChildHashSet.addAll(Arrays.asList('N', 'B', 'A'));

        assertFalse(badChildHashSet.getAddCount() == 3);
        assertEquals(6, badChildHashSet.getAddCount());
    }
}
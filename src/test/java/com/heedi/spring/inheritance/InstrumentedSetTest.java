package com.heedi.spring.inheritance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentedSetTest {

    @Test
    void add_test() {
        InstrumentedSet<Character> instrumentedSet = new InstrumentedSet<>(new HashSet<>());

        instrumentedSet.add('N');
        instrumentedSet.add('B');
        instrumentedSet.add('A');

        assertEquals(3, instrumentedSet.getAddCount());
    }

    @Test
    void addAll_test() {
        InstrumentedSet<Character> instrumentedSet = new InstrumentedSet<>(new HashSet<>());

        instrumentedSet.addAll(Arrays.asList('N', 'B', 'A'));

        assertEquals(3, instrumentedSet.getAddCount());
    }
}
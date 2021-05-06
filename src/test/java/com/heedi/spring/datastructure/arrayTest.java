package com.heedi.spring.datastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class arrayTest {

    @Test
    void array_add() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
//        arrayList.add(3, 4);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1); // 5
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1); // 10

        arrayList.add(1);
        arrayList.add(3, 4);

        System.out.println(arrayList);

        assertSame(12, arrayList.size());
        assertEquals(Integer.valueOf(4), arrayList.get(3));
    }

    @Test
    void array_get() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3, 4);

        System.out.println(arrayList);
    }
}

package com.heedi.spring;

import com.heedi.spring.model.Cat;
import com.heedi.spring.model.Character;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTest {

    private static final Character KIND = Character
            .builder()
            .tendency("kind")
            .build();

    private static final Cat MOMO = Cat.builder()
            .name("momo")
            .age(5)
            .character(KIND)
            .build();

    private static final Cat DD = Cat.builder()
            .name("dd")
            .age(6)
            .character(KIND)
            .build();

    private Hashtable<Character, Cat> table = new Hashtable<>();
    private HashMap<Cat, Integer> map = new HashMap<>();
    private ConcurrentHashMap<Cat, String> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    void hashtable_synchronized() {
        // method 자체에 synchronized 처리
        // this에 Lock이 걸림 (성능 저하)
        table.put(KIND, MOMO);
        table.get(KIND);
    }

    @Test
    void hashtable_null_value() {
        assertThatNullPointerException()
                .isThrownBy(() -> table.put(KIND, null));
    }

    @Test
    void hashtable_null_key() {
        assertThatNullPointerException()
                .isThrownBy(() -> table.put(null, DD));
    }

    @Test
    void map_synchronized() {
        // no synchronized
        map.put(MOMO, 3);
        // no synchronized
        map.get(KIND);
    }

    @Test
    void hashMap_null_value() {
        map.put(DD, null);

        assertNull(map.get(DD));
    }

    @Test
    void hashMap_null_key() {
        map.put(null, 0);

        assertEquals(0, (int) map.get(null));
    }

    @Test
    void concurrentHashMap_s() {
        // Node에 synchronized 처리
        // MultiThread에 유리
        concurrentHashMap.put(MOMO, "MOMO");
        // no synchronized
        concurrentHashMap.get(MOMO);
    }

    @Test
    void concurrentHashMap_null_value() {
        assertThatNullPointerException()
                .isThrownBy(() -> concurrentHashMap.put(MOMO, null));
    }

    @Test
    void concurrentHashMap_null_key() {
        assertThatNullPointerException()
                .isThrownBy(() -> concurrentHashMap.put(null, "DD"));
    }
}

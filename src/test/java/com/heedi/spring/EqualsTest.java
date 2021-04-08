package com.heedi.spring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EqualsTest {

    @Test
    void float_equals() {
        float f1 = 2.2f;
        float f2 = 2.2f;

        assertEquals(f1, f2);

        boolean isEquals = Float.floatToIntBits(f1) == Float.floatToIntBits(f2);
        assertTrue(isEquals);
    }

    @Test
    void String_equals() {
        String s1 = new String("string");
        String s2 = new String("String");
        String s3 = new String("String");

        assertFalse(s1.equals(s2));

        assertTrue(s2.equals(s3));
        assertFalse(s2 == s3);

        assertFalse(s1.equals(s3));
    }
}

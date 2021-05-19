package com.heedi.spring.assertion;

import com.heedi.spring.model.Character;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqualsTest {

    private Character character1;
    private Character character2;

    @Before
    public void setup() {
        String tendency = "kind";
        String etc = "";

        character1 = Character.builder()
                .tendency(tendency)
                .etc(etc)
                .build();

        character2 = Character.builder()
                .tendency(tendency)
                .etc(etc)
                .build();
    }

    @Test
    public void assertEquals_Object_Equals() {
        // obj1.equals(obj2);
        assertEquals(character1, character2);
    }


    @Test
    public void assertThat_isEqualsTo_Object() {
        // java.util.Objects.deepEquals(actual, other)
        // Arrays.equals(actual, other)
        assertThat(character1).isEqualTo(character2);
    }
}

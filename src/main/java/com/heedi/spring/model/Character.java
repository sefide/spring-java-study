package com.heedi.spring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Builder
@Getter
public class Character {
    private String tendency;
    private String etc;

    public boolean isKind() {
        return tendency.equals("kind");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return getTendency().equals(character.getTendency()) &&
                Objects.equals(getEtc(), character.getEtc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTendency(), getEtc());
    }
}

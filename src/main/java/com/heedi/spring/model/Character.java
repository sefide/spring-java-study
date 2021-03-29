package com.heedi.spring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class Character {
    private String tendency;
    private String etc;

    public boolean isKind() {
        return tendency.equals("kind");
    }
}

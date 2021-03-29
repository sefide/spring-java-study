package com.heedi.spring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
public class Cat {

    private String name;
    private int age;
    private String nickName;
    private List<Cat> friends;
    private Character character;

//    @JsonIgnore
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isOld() {
        return age > 10;
    }

    public String getNameSpace() {
        return name + "> " + nickName;
    }

    public boolean hasFriends() {
        return !CollectionUtils.isEmpty(friends);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                Objects.equals(name, cat.name) &&
                Objects.equals(nickName, cat.nickName) &&
                Objects.equals(friends, cat.friends) &&
                Objects.equals(character, cat.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, nickName, friends, character);
    }
}

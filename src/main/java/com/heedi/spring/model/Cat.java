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
        if (this == o) return true; // 자기 자신에 대한 참조인지 확인
        if (!(o instanceof Cat)) return false; // 입력이 올바른 타입인지 확인
        Cat cat = (Cat) o; // 입력을 올바른 타입으로 형변환

        // 입력 객체와 자신이 대응되는 핵심 필드들이 일치하는지 확인
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

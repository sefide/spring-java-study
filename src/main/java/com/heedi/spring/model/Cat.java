package com.heedi.spring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
}

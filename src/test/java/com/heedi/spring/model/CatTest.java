package com.heedi.spring.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CatTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("ObjectMapper를 이용한 Object To Map 변환 테스트")
    @Test
    public void Cat_객체_Map_변환_테스트() {
        Character character = Character.builder()
                .tendency("kind")
                .build();

        Cat cat = Cat.builder()
                .name("momo")
                .age(5)
                .nickName("")
                .character(character)
                .build();

//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // null 값만 제거
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT); // null, empty, old 제외
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT); // null 값만 제외
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // null, empty 제외
//        objectMapper.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS); // 전체 노출
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE)
                .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);

//        objectMapper
//                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
//                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        // null값은 살아있으면서 old는 제외되 어야 함.
        Map<String, Object> map = objectMapper.convertValue(cat, Map.class);

        System.out.println(map);
    }
}
package com.heedi.spring;

import com.heedi.spring.model.Dog;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransientTest {

    private static final String FILE_NAME = "src/test/resources/transient/Dogs.txt";

    @Test
    void test() {
        Dog dog = Dog.builder()
                .name("Duyong")
                .age(1)
                .id("DY")
                .nameCode("cute cute")
                .build();

        doSerialize(dog); // 직렬화
        Dog readDog = doDeSerialize(); // 역직렬화

        assertNull(readDog.getNameCode());
        assertEquals(dog.getName(), readDog.getName());
        assertEquals(dog.getAge(), readDog.getAge());
        assertEquals(dog.getId(), readDog.getId());
    }

    void doSerialize(Dog dog) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(dog);

        } catch (IOException e) {
            System.out.println("serialize object : " + dog + ", error .. {" + e.getMessage() + "}");
        }
    }

    private Dog doDeSerialize() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (Dog) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("deserialize error .. FileNotFoundException {" + e.getMessage() + "}");
        } catch (IOException e) {
            System.out.println("deserialize  error .. IOException {" + e.getMessage() + "}");
        } catch (ClassNotFoundException e) {
            System.out.println("deserialize case error .. {" + e.getMessage() + "}");
        }

        return Dog.empty();
    }
}

package com.capgemini.extra;

import com.github.javafaker.Faker;
import org.junit.Test;

public class FakerTest {

    @Test
    public void dummyNames() {
        Faker faker = new Faker();
        for(int i=1; i <= 10; i++) {
            System.out.println(i + ") " + faker.name().fullName());
        }
    }

    @Test
    public void dummyAddress() {
        Faker faker = new Faker();
        for(int i=1; i <= 10; i++) {
            System.out.println(i + ") " + faker.address().fullAddress());
        }
    }

    @Test
    public void dummyLotr() {
        Faker faker = new Faker();
        for(int i=1; i <= 10; i++) {
            System.out.println(i + ") " + faker.lordOfTheRings().character());
        }
    }
}

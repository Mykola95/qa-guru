package com.demoqa.dslstyle.utils;

import org.junit.jupiter.api.Test;

import static com.demoqa.dslstyle.utils.RandomUtils.*;

public class randomUtilsExample {
    @Test
    void ramdom() {
        System.out.println(getRandomString(10));

        int randomInt = getRandomInt(223333, 100000000);
        System.out.println(randomInt + "");

        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);
    }
}
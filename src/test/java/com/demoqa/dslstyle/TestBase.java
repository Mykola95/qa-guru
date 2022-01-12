package com.demoqa.dslstyle;

import com.codeborne.selenide.Configuration;
import com.demoqa.dslstyle.pages.RegistrationPageDsl;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPageDsl registrationPage = new RegistrationPageDsl();
    Faker faker = new Faker();
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}

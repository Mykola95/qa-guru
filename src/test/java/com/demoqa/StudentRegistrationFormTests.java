package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@gmail.com");
        $(".custom-radio:nth-child(1) .custom-control-label").click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOption("May");
        $("[class*='year-select']").selectOption("1995");
        $("[class*='datepicker__day--010']").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(".custom-checkbox:nth-child(2) .custom-control-label").click();
        $("#currentAddress").setValue("Test");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").scrollTo().click();
    }
}

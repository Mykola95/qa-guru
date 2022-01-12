package com.demoqa.selenidestyle.checkhomework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentsRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");

//        $("#gender-radio-3").click(); // NOT WORKING
//        $("#gender-radio-3").doubleClick(); // BUT WHY?
//        $("#gender-radio-3").parent().click();
//        $("label[for=gender-radio-3]").click();
//        $(byText("Other")).click(); // BAD PRACTICE
        $("#genterWrapper").$(byText("Other")).click();

        $("#userNumber").setValue("1231231230");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--030")
//                .filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first() // or .get(0)
//                .click();
//        $("[aria-label=Choose Wednesday, July 30th, 2008]").click(); // NOT WORKING
//        $("[aria-label=\"Choose Wednesday, July 30th, 2008\"]").click();
//        $("[aria-label='Choose Wednesday, July 30th, 2008']").click();
        $("[aria-label$='July 30th, 2008']").click();
//        $x("//*[contains(@aria-label, \"July 30th, 2008\")]").click();

// <div class="react-datepicker__day--030 react-datepicker__day--outside-month"  aria-label="Choose Monday, June 30th, 2008">30</div>
// <div class="react-datepicker__day--030"                                       aria-label="Choose Wednesday, July 30th, 2008">30</div>

        $("#subjectsInput").setValue("Math").pressEnter();

//        $("#subjectsInput").setValue("M"); // todo Why not working
//        $("#subjectsWrapper").$(byText("Math")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        File someFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(someFile);
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Some address 1");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        // todo Asserts
    }
}

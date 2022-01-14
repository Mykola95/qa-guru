package com.demoqa.dslstyle;

import com.codeborne.selenide.Configuration;
import com.demoqa.dslstyle.pages.RegistrationPageDsl;
import com.demoqa.pageobjectsstyle.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.dslstyle.TestData.email;
import static com.demoqa.dslstyle.utils.RandomUtils.getRandomString;

public class StudentRegistrationFormTests extends TestBase {
    String firstName = getRandomString(10),
            lastName = "Egorov";
//    String email = faker.name().firstName();
    String email1 = faker.internet().emailAddress();
    @Test
    void fillFormTest() {
        registrationPage.openPage().typeFirstName(firstName).typeLastName(lastName).setBirthDate("10", "May", "1995");
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1231231230");
//        registrationPage.calendarComponent.setDate("10","May","1995");
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Name", "Alex Egorov")
                .checkResultsValue("Student Name", "Alex Egorov");
    }
}

package com.demoqa.selenidestyle;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("emain@email.com");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").scrollTo().click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("emain@email.com"));
        $("#output #currentAddress").shouldHave(text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(text("Another address"));
    }

    @Test
    void searchGoogle(){
        open("https://www.google.com/");
        $(By.name("q")).setValue("Selenide").pressEnter();
        $$("#rso .yuRUbf").shouldHave(sizeGreaterThan(4));
        $("#rso .yuRUbf").shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }
}

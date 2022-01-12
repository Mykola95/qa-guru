package com.demoqa.dslstyle.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.dslstyle.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageDsl {
    private final SelenideElement
            formTitle = $(".practice-form-wrapper");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement resultsTable = $(".table-responsive");

    public RegistrationPageDsl openPage() {
        open("/automation-practice-form");
        String FORM_TITLE = "Student Registration Form";
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPageDsl typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPageDsl typeLastName(String value) {
        lastNameInput.setValue(value);
        return new RegistrationPageDsl();
    }

    public RegistrationPageDsl checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPageDsl setBirthDate(String day, String month, String year) {
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    /*
    public AnotherPage clickOnAnotherPage() {
        $("").click();
        return new AnotherPage();
    }
     */
}

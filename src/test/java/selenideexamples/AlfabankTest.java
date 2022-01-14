package selenideexamples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
    @Test
    void testAlfa() {
        open("https://alfabank.ru");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Накопительные продукты"));
        $(byText("Депозиты")).click();
    }
}

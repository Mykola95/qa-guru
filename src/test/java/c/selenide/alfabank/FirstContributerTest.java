package c.selenide.alfabank;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class FirstContributerTest {

    @Test
    void firstContrubuterShouldBeAndreiSolntsev(){
        // открыть страничку репозитория Селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому элементу в области Contributors
        //$(".Layout-sidebar").$(byText("Contributors")).closest("div")
        //                .$$("ul li").first().hover();

        $$(".Layout-sidebar .BorderGrid-row").find(text("Contributors"))
                .$$("ul li").first().hover();
        // check: в появившемся окошке (оверлей) текст Andrei Solntsev
        $$(".Popover-message").shouldHave(texts("Andrei Solntsev"));

    }
}
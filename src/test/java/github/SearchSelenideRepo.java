package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {
    @Test
    void shouldFindSelenideRepositoryInGithub() {
//      открыть страницу github.com
        open("https://github.com/");
//      ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
//      нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
//      $("ul.repo-list li").$("a").click();
//       check: в заголовке встречается selenide/selenide
        sleep(4000);
        $("h1").shouldHave(text("selenide / selenide"));

        sleep(5000);


//        ARRANGE (optional)
//        ACT
//        ACT
//        ASSERT
//        ACT
//        ASSERT

    }
}

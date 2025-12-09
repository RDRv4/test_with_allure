import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindIssuesInGitHubPage {

    @Test
    void findIssuesOnClearSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8");
        $(".vector-search-box-input").pressEnter();
        $("[title='Искать в Википедии']").setValue("мотобол").pressEnter();
        $$(".mw-search-results-container a").findBy(text("Мотобол")).click();
        $("#bodyContent").
                shouldHave(text(" — один из видов мотоспорта, представляет собой игру в "));

        sleep(2000);
    }
}

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FindIssuesInGitHubPage1 {

    public static final String USSEARCH = "мотобол";

    @Test
    void findIssuesOnClearSelenideWithLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открывает wikipedia", () -> {
            open("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8");
        });

        step("Нажимаем на поле search", () -> {
            $(".vector-search-box-input").pressEnter();
        });

        step("В поле search вводим значение " + USSEARCH, () -> {
            $("[title='Искать в Википедии']").setValue(USSEARCH).pressEnter();
        });

        step("Выполняем проверку по ключевому слову " + USSEARCH, () -> {
            $$(".mw-search-results-container a").findBy(text(USSEARCH)).click();
            $("#bodyContent").
                    shouldHave(text(" — один из видов мотоспорта, представляет собой игру в "));
        });

        sleep(2000);
    }

    @Test
    void findIssuesOnClearSelenideWithStepsClass() {

        FindIssuesInGitHubPage2WithSteps findIssuesInGitHubPage2WithSteps = new FindIssuesInGitHubPage2WithSteps();

        findIssuesInGitHubPage2WithSteps.openPage();
        findIssuesInGitHubPage2WithSteps.clickOnSearchInput();
        findIssuesInGitHubPage2WithSteps.setValueInSearchInput(USSEARCH);
        findIssuesInGitHubPage2WithSteps.checkByString(USSEARCH);
        findIssuesInGitHubPage2WithSteps.openPage();

    }

}

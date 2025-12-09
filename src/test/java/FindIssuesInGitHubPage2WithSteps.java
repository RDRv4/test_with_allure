import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FindIssuesInGitHubPage2WithSteps {

    @Step("Открывает wikipedia")
    void openPage() {
        open("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8");
    }

    @Step("Нажимаем на поле search")
    void clickOnSearchInput() {
        $(".vector-search-box-input").pressEnter();
    }

    @Step("В поле search вводим значение ")
    void setValueInSearchInput(String s) {
        $("[title='Искать в Википедии']").setValue(s).pressEnter();
    }

    @Step("Выполняем проверку по ключевому слову ")
    void checkByString(String s) {
        $$(".mw-search-results-container a").findBy(text(s)).click();
        $("#bodyContent").
                shouldHave(text(" — один из видов мотоспорта, представляет собой игру в "));
    }

}

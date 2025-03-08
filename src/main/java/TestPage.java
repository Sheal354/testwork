import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Класс главной страницы.
 */
public class TestPage {
    /**
     * Проверяет, что страница открылась.
     * @return экземпляр класса InputsTest
     */
    @Step("Проверить, что страница открылась")
    public InputsTest pageIsOpen() {
        $(By.xpath("//h1"))
                .should(exist);
        return page(InputsTest.class);
    }
}

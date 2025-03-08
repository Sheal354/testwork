import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Класс для выбора чекбоксов Milk и Coffee.
 */
public class CheckboxTest {
    /**
     * Чекбокс для выбора Milk
     */
    @FindBy(xpath = "//input[@value='Milk']")
    private SelenideElement milkCheckbox;

    /**
     * Чекбокс для выбора Coffee
     */
    @FindBy(xpath = "//input[@value='Coffee']")
    private SelenideElement coffeeCheckbox;

    /**
     * Проверяет, что чекбоксы существуют.
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что чекбоксы существуют")
    public CheckboxTest checkboxExists() {
        milkCheckbox.shouldBe(visible);
        coffeeCheckbox.shouldBe(visible);
        sleep(1000);
        return this;
    }

    /**
     * Выбор чекбоксов Milk и Coffee
     * @return текущий экземпляр класса
     */
    @Step("Выбор чекбоксов Milk и Coffee")
    public CheckboxTest chooseCheckbox() {
        milkCheckbox.click();
        coffeeCheckbox.click();
        sleep(1500);
        return this;
    }
}

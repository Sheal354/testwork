import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Класс для выбора radio Yellow.
 */
public class RadioTest {
    /**
     * Radio для выбора Yellow
     */
    @FindBy(xpath = "//input[@value='Yellow']")
    private SelenideElement yellowRadio;

    /**
     * Проверяет, что radio существует.
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что чекбоксы существуют")
    public RadioTest radioExists() {
        yellowRadio.shouldBe(visible);
        sleep(1000);
        return this;
    }

    /**
     * Выбор radio Yellow
     * @return текущий экземпляр класса
     */
    @Step("Выбор radio Yellow")
    public RadioTest chooseRadio() {
        yellowRadio.click();
        sleep(1500);
        return this;
    }
}

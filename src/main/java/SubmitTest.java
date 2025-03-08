import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

/**
 * Класс для проверки действия кнопки Submit
 */
public class SubmitTest {
    /**
     * Кнопка Submit
     */
    @FindBy(xpath = "//button[@data-testid='submit-btn']")
    private SelenideElement submitBtn;

    /**
     * Нажатие на кнопку Submit и проверка появления алерта с текстом
     * @return текущий экземпляр класса
     */
    @Step("Нажатие на кнопку Submit и проверка появления алерта с текстом")
    public SubmitTest btnTest() {
        submitBtn
                .shouldBe(visible)
                .click();
        sleep(1500);

        // Переключаемся на алерт и проверяем его текст
        String alertText = switchTo().alert().getText();

        // Проверяем, что текст алерта соответствует ожидаемому
        assertEquals(alertText, "Message received!");

        // Принимаем алерт (нажимаем "OK")
        switchTo().alert().accept();
        return this;
    }
}

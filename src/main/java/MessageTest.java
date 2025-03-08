import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.Optional;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Класс для ввода в поле Message
 */
public class MessageTest {
    /**
     * Поле для ввода текста Message
     */
    @FindBy(id = "message")
    private SelenideElement messageTextArea;

    /**
     * Список инструментов
     */
    @FindBy(xpath = "//label[contains(text(), 'Automation tools')]/following-sibling::ul")
    private SelenideElement automationToolsList;

    /**
     * Проверяет, что поле для ввода и список инструментов существуют
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что поле для ввода и список инструментов существуют")
    public MessageTest messageExist() {
        messageTextArea.shouldBe(visible);
        automationToolsList.shouldBe(visible);
        sleep(1000);
        return this;
    }

    /**
     * Находит и вводит количество инструментов и инструмент с наибольшим кол-вом символов в поле Message.
     * @return текущий экземпляр класса
     */
    @Step("Ввод в поле Message количество инструментов и инструмент с наибольшим кол-вом символов")
    public MessageTest messageInput() {
        // Находим все инструменты внутри списка инструментов
        ElementsCollection tools = automationToolsList.$$("li");
        tools.forEach(tool -> tool.shouldBe(visible));
        Optional<SelenideElement> longestElement = tools
                .asFixedIterable()
                .stream()
                .max((e1, e2) -> Integer.compare(e1.getText().length(), e2.getText().length()));

        longestElement.ifPresent(
                element -> messageTextArea.sendKeys(tools.size() + "\n" + element.getText())
        );

        sleep(1000);
        return this;
    }

}

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.Random;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Класс для выбора опций элемента select.
 */
public class SelectTest {
    /**
     * Элемент Select
     */
    @FindBy(xpath = "//select[@data-testid='automation']")
    private SelenideElement select;

    /**
     * Проверяет, что элемент select и его option существуют, а затем выбирает случайный элемент option
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что элементы option существуют, выбрать случайный")
    public SelectTest selectTest() {
        select
                .shouldBe(visible)
                .click();
        sleep(1500);
        // Находим все элементы option внутри select
        ElementsCollection options = select.$$("option");
        options.forEach(option -> option.shouldBe(visible));

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        options.get(randomIndex).click();
        sleep(1500);
        return this;
    }
}

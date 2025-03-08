import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс для заполнения полей Name, Password и Email.
 */
public class InputsTest {
    /**
     * Поле для ввода имени
     */
    @FindBy(id = "name-input")
    private SelenideElement nameInput;

    /**
     * Поле для ввода пароля
     */
    @FindBy(css = "input[type='password']")
    private SelenideElement passwordInput;


    /**
     * Поле для ввода адреса электронной почты
     */
    @FindBy(xpath = "//input[@data-testid='email']")
    private SelenideElement emailInput;

    /**
     * Проверяет, что поля для ввода существуют.
     * @return текущий экземпляр класса
     */
    @Step("Проверить, что поля для ввода существуют")
    public InputsTest inputsExists() {
        nameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        emailInput.shouldBe(visible);
        return this;
    }

    /**
     * Набор данных для имитации действий пользователей
     */
    @DataProvider(name = "inputData")
    public static Object[][] InputsProvider() {
        return new Object[][] {
                {"Alexey", "123", "Lesha@example.com"},
                {"Oleg", "123456", "oleja@example.com"},
                {"Antonina", "190990", "Antonina90@example.com"},
                {"Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr", "10000000000000000", "HBWS@example.com"}
        };
    }

    /**
     * Вводит данные в поля ввода. Вызывает тесты для чекбоксов
     */
    @Step("Тестирование полей для ввода")
    public void test(String name, String password, String email) {
        nameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        sleep(1500);
        page(CheckboxTest.class)
                .checkboxExists()
                .chooseCheckbox();
        page(RadioTest.class)
                .radioExists()
                .chooseRadio();
        page(SelectTest.class)
                .selectTest();
        emailInput.sendKeys(email);
        page(MessageTest.class)
                .messageExist()
                .messageInput();
        sleep(1500);
        page(SubmitTest.class)
                .btnTest();
    }
}

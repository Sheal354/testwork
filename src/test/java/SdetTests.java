import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class SdetTests extends BaseTest{

    @Test(description = "Page test")
    public void pageOpenTest() {
        page(TestPage.class)
                .pageIsOpen()
                .inputsExists();
        sleep(1000);
    }

    @Test(description = "Inputs test", dataProvider = "inputData", dataProviderClass = InputsTest.class)
    public void inputsTest(String name, String password, String email) {
        page(InputsTest.class).test(name, password, email);
        sleep(1000);
    }

}

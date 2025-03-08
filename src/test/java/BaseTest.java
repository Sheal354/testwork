import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    void initBeforeClass() {
        Configuration.baseUrl = "https://practice-automation.com/form-fields/";
        Configuration.browserSize = "1920x2100";
        Configuration.timeout = 30000;
        open("/");
    }
}

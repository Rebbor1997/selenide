package baseEntities;

import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public static void setupAllureReports(){
        /*SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
*/
        Configuration.baseUrl = ReadProperties.getInstance().getURL();
        Configuration.browser = ReadProperties.getInstance().getBrowser();
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
    }
}

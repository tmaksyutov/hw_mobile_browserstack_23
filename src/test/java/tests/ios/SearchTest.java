package tests.ios;


import io.appium.java_client.AppiumBy;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class SearchTest extends TestBase {

    @Test
    void check(){
        $(AppiumBy.accessibilityId("Text Button")).click();
        $(AppiumBy.accessibilityId("Text Input")).sendKeys("hello@browserstack.com");
        sleep(5000);
        $(AppiumBy.accessibilityId("Text Output")).shouldHave(text("hello@browserstack.com"));
    }

}


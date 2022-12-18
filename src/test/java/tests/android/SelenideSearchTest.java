package tests.android;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideSearchTest extends TestBase {

    @Test
    void successSearchWikiTest() {
        step("Skip settings", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JavaScript");
        });
        step("Verify content found", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });

    }
}

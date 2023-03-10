package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {
    @BeforeAll
    public static void setUp() {

        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = sessionId().toString();

        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();

        closeWebDriver();

        AttachHelper.video(sessionId);

        // attach
    }
}

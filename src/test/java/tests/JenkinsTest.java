package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import utils.Attach;
import java.util.Map;


@Tag("forJenkins")
public class JenkinsTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3840 x 2160";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.attachScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();


    }

    @Test
    void fillFormRequaredTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .dontShowBanner()
                .setFirstName("Anton")
                .setLastName("Stepanov")
                .setEmail("s.anthony2808@gmail.com")
                .setGender("Male")
                .setPhoneNumber("9999999999")
                .setCurrentAddress("s.anthony2808@gmail.com")
                .setDateOfBirth("28", "August", "1991")
                .submit()
                .checkResult("Student Name", "Anton Stepanov")
                .checkResult("Student Email", "s.anthony2808@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "28 August,1991")
                .checkResult("Address", "s.anthony2808@gmail.com");
    }
}


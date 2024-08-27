package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("forJenkins")
public class JenkinsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

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


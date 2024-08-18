package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


@Tag("forJenkins")
public class JenkinsTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3840 x 2160";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }

    @Test
    void fillFormRequaredTest() {
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

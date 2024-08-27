package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class TextFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

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

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .dontShowBanner()
                .setFirstName("Anton")
                .setLastName("Stepanov")
                .setEmail("s.anthony2808@gmail.com")
                .setGender("Male")
                .setPhoneNumber("9999999999")
                .setCurrentAddress("s.anthony2808@gmail.com")
                .setSubjects("English")
                .setHobby("Music")
                .setDateOfBirth("28", "August", "1991")
                .setState("NCR")
                .setCity("Noida")
                .uploadPicture()
                .submit()
                .checkResult("Student Name", "Anton Stepanov")
                .checkResult("Student Email", "s.anthony2808@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "magic.jpg")
                .checkResult("Date of Birth", "28 August,1991")
                .checkResult("Address", "s.anthony2808@gmail.com")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void fillFormNegativeTest() {
        registrationPage.openPage()
                .dontShowBanner()
                .setFirstName("Anton")
                .setLastName("Stepanov")
                .setEmail("s.anthony2808@gmail.com")
                .setGender("Male")
                .setWrongNumber("wwwwwwwwwwww")
                .setCurrentAddress("s.anthony2808@gmail.com")
                .setDateOfBirth("28", "August", "1991")
                .submit()
                .negativeResult();
    }

}

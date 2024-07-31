package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static utils.TestData.*;

public class TextFormFakerTest extends TestBase{


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .dontShowBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setCurrentAddress(currentAddress)
                .setSubjects(subjects)
                .setHobby(hobby)
                .setDateOfBirth(BirthDay, BirthDayMonth, BirthDayYear)
                .setState(state)
                .setCity(city)
                .uploadPicture()
                .submit()
                .checkResult("Student Name", firstName)
                .checkResult("Student Name", lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile",phoneNumber)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "magic.jpg")
                .checkResult("Date of Birth", BirthDayYear)
                .checkResult("Date of Birth", BirthDayMonth)
                .checkResult("Date of Birth", BirthDay)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state)
                .checkResult("State and City", city);
    }
}

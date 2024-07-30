package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static utils.RandomUtils.*;
import static utils.TestData.*;

public class TextFormFakerTest extends TestBase{

    String phoneNumber = getRandomString(10);
    String gender = getRandomGender();
    String subjects = "English";
    String hobby = getRandomHobby();
    String state = "NCR";
    String city = "Noida";
    String day = "28";
    String month = "August";
    String year = "1991";


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
                .setDateOfBirth(day, month, year)
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
                .checkResult("Date of Birth", year)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state)
                .checkResult("State and City", city);
    }
}

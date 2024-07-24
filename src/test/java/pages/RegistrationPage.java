package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.RegistrationResult;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            setEmailInput = $("#userEmail"),
            setCurrentAddressInput = $("#currentAddress"),
            setGenderInput = $("#genterWrapper"),
            setPhoneNumberInput = $("#userNumber"),
            setSubjectsInput = $("#subjectsInput"),
            setDateOfBirthInput = $("#dateOfBirthInput"),
            setHobbyInput = $("#hobbiesWrapper"),
            setStateInput = $("#state"),
            setCityInput = $("#city"),
    submitButton =  $("#submit"),
    upload = $("#uploadPicture");

    Calendar calendar = new Calendar();
    RegistrationResult registrationResult = new RegistrationResult();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        setEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        setGenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        setPhoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setWrongNumber(String value) {
        setPhoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        setCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        setSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        setHobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        setDateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setState(String value) {
        setStateInput.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        setCityInput.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

    public RegistrationPage uploadPicture(){
        upload.uploadFromClasspath("magic.jpg");
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        registrationResult.result(key, value);
        return this;
    }

    public RegistrationPage negativeResult () {
        $(".table-responsive").shouldNotBe(visible);
        return this;
    }

}

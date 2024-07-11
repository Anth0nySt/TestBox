package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextFormTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "3840 x 2160";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";

        }

        @Test
        void fillFormTest() {
            open("https://demoqa.com/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");


            $("#firstName").setValue("Anton");
            $("#lastName").setValue("Stepanov");
            $("#userEmail").setValue("s.anthony2808@gmail.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("9999999999");
            $("#currentAddress").setValue("s.anthony2808@gmail.com");
            $("#state").click();
            $("#state").$(byText("NCR")).click();
            $("#city").click();
            $("#city").$(byText("Noida")).click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("2012");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__day--008").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#uploadPicture").uploadFromClasspath("magic.jpg");
            $("#submit").click();

            $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(Condition.text("Anton Stepanov"));
            $(".table-responsive").shouldHave(Condition.text("s.anthony2808@gmail.com"));
            $(".table-responsive").shouldHave(Condition.text("08 August,2012"));
            $(".table-responsive").shouldHave(Condition.text("English"));
            $(".table-responsive").shouldHave(Condition.text("Music"));
            $(".table-responsive").shouldHave(Condition.text("s.anthony2808@gmail.com"));
            $(".table-responsive").shouldHave(Condition.text("NCR Noida"));
            $(".table-responsive").shouldHave(Condition.text("Male"));
            $(".table-responsive").shouldHave(Condition.text("magic.jpg"));
        }

    }

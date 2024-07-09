package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


    public class TextFormTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "3840 x 2160";
        }

        @Test
        void FillFormTest() {

            open("https://demoqa.com/automation-practice-form");

            $("#firstName").setValue("Anton");
            $("#lastName").setValue("Stepanov");
            $("#userEmail").setValue("s.anthony2808@gmail.com");
            $(".custom-radio:nth-child(1) > .custom-control-label").click();
            $("#userNumber").setValue("9999999999");
            $("#currentAddress").setValue("s.anthony2808@gmail.com");
            $(".css-tlfecz-indicatorContainer > .css-19bqh2r").click();
            $("#react-select-3-option-0").click();
            $(".css-tlfecz-indicatorContainer > .css-19bqh2r").click();
            $("#react-select-4-option-1").click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("2012");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__day--008").click();
            $(".custom-checkbox:nth-child(3) > .custom-control-label").click();
            $("#subjectsInput").setValue("s");
            $("#react-select-2-option-4").click();
            File filetoupload = new File("src/test/java/resources/Magic.jpg");
            $("#uploadPicture").uploadFile(filetoupload);
            $("#submit").click();
            $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        }

    }

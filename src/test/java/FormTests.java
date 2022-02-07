import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    final String name = "John";
    final String surname = "Smith";
    final String email = "testmail@mail.com";
    final String phoneNumber = "8800555353";
    final String day = "10";
    final String month = "May";
    final String year = "1978";
    final String subjectsInput = "Hist";
    final String fileName = "rickroll.jpg";
    final String currentAddress = "Baker St. 228b";
    final String state = "NCR";
    final String city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1500x1200";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillForm() {
        //name
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);

        //email
        $("#userEmail").setValue(email);

        //gender
        $("[for=gender-radio-3]").click();

        //mobile number
        $("#userNumber").setValue(phoneNumber);

        //birth date
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOption(month);
        $("[class*='year-select']").selectOptionByValue(year);
        $("[class*='datepicker__day--0" + day + "']").click();

        //subjects
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();

        //sleep(5000);

        //hobbies
        $(byText("Sports")).click();

        //picture
        $("[class*='form-control-file']").uploadFromClasspath(fileName);

        //current address
        $("#currentAddress").setValue(currentAddress);

        //state and city
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").scrollIntoView(true).click();

        checkResult();

        $("#closeLargeModal").click();
    }

    void checkResult() {
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(
          text(name + " " + surname),
          text(email),
          text("Other"),
          text(phoneNumber),
          text(day + " " + month + "," + year),
          text("History"),
          text("Sports"),
          text(fileName),
          text(currentAddress),
          text(state + " " + city)
        );
    }

    @AfterAll
    static void close() {
        closeWebDriver();
    }

}

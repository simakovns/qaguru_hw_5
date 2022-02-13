import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.form.FormPage;
import pages.form.ModalWindow;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormTests extends TestBase{

    final Faker faker = new Faker(new Locale("ru"));

    final String name = faker.pokemon().name();
    final String surname = faker.gameOfThrones().house();
    final String email = faker.internet().emailAddress();
    final String genderRadioNumber = "3";
    final String phoneNumber = String.valueOf(faker.number().numberBetween(1111111111L, 9999999999L));
    final String day = "10";
    final String month = "May";
    final String year = "1978";
    final String subjectsInput = "Hist";
    final String hobbieCheckboxNumber = "2";
    final String fileName = "rickroll.jpg";
    final String currentAddress = faker.address().streetAddress();
    final String state = "NCR";
    final String city = "Delhi";

    @Test
    void fillForm() {
        open("https://demoqa.com/automation-practice-form");
        final FormPage formPage = new FormPage();

        formPage.setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .clickGenderRadioWithNumber(genderRadioNumber)
                .setPhoneNumber(phoneNumber)
                .setDate(day, month, year)
                .setSubjects(subjectsInput)
                .clickHobbieCheckbox(hobbieCheckboxNumber)
                .uploadPicture(fileName)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        final ModalWindow modalWindow = new ModalWindow();
        modalWindow
                .checkResult(name + " " + surname)
                .checkResult(email)
                .checkResult("Other")
                .checkResult(phoneNumber)
                .checkResult(day + " " + month + "," + year)
                .checkResult("History")
                .checkResult("Reading")
                .checkResult(fileName)
                .checkResult(currentAddress)
                .checkResult(state + " " + city)
                .closeModal();
    }

    @AfterAll
    static void close() {
        closeWebDriver();
    }

}

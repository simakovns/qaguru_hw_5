package pages.form;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {
    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsContainer = $("#subjectsContainer"),
            subjectsInput = $("#subjectsInput"),
            pictureUpload = $("[class*='form-control-file']"),
            address = $("#currentAddress"),
            stateSelect = $("#react-select-3-input"),
            citySelect = $("#react-select-4-input"),
            submit = $("#submit");

    private SelenideElement genderRadio;

    final CalendarComponent calendarComponent = new CalendarComponent();

    public FormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public FormPage setFirstName(final String firstName) {
        this.firstName.setValue(firstName);
        return this;
    }

    public FormPage setLastName(final String lastName) {
        this.lastName.setValue(lastName);
        return this;
    }

    public FormPage setEmail(final String userEmail) {
        this.userEmail.setValue(userEmail);
        return this;
    }

    public FormPage clickGenderRadioWithNumber(final String genderRadioNumber) {
        genderRadio = $("[for=gender-radio-" + genderRadioNumber +"]");
        genderRadio.click();
        return this;
    }

    public FormPage setPhoneNumber(final String phoneNumber) {
        this.userNumber.setValue(phoneNumber);
        return this;
    }

    public FormPage setDate(final String day, final String month, final String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormPage setSubjects(final String subject) {
        subjectsContainer.click();
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public FormPage clickHobbieCheckbox(final String number) {
        $("#hobbies-checkbox-" + number).parent().click();
        return this;
    }

    public FormPage uploadPicture(final String filePath) {
        pictureUpload.uploadFromClasspath(filePath);
        return this;
    }

    public FormPage setAddress(final String address) {
        this.address.setValue(address);
        return this;
    }

    public FormPage setState(final String state) {
        stateSelect.setValue(state).pressEnter();
        return this;
    }

    public FormPage setCity(final String city) {
        citySelect.setValue(city).pressEnter();
        return this;
    }

    public void submit() {
        submit.scrollIntoView(true).click();
    }
}

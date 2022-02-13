package pages.form;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {
    private SelenideElement modalWindow = $("#closeLargeModal"),
            modalContent = $(".modal-content"),
            table = $(".table-responsive");

    public void closeModal() {
        modalWindow.click();
    }

    public ModalWindow checkResult(final String value) {
        modalContent.shouldBe(visible);
        table.shouldHave(text(value));
        return this;
    }
}

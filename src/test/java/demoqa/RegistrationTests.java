package demoqa;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase{

    @Test
    void successTest(){
        step("Открыть главную страницу", () -> open("/automation-practice-form"));
        step("Заполнить Имя", () -> {
            $("#firstName").setValue("Alex");
        });
        step("Заполнить Фамилию", () -> {
            $("#lastName").setValue("Ivanov");
        });
        step("Заполнить email", () -> {
            $("#userEmail").setValue("Test@mail.ru");
        });
        step("Заполнить поле Номер телефона", () -> {
            $(".custom-control-label").click();
            $("#userNumber").setValue("0123456789");
        });
        step("Заполнить дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("March");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1995");
            $x("//div[text()='14']").click();
        });
        step("Выбрать предмет", () -> {
            $("#subjectsInput").setValue("History").pressEnter();
        });
        step("Выбрать хобби", () -> $x("//label[text()='Music']").click());
        step("Указать адрес", () -> {
            $("#currentAddress").setValue("Tiraspol");
        });
        step("Заполнить все остальное", () -> {
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Gurgaon").pressEnter();
            $("#submit").click();
        });
        step("Проверить правильность заполнения всех полей", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
            $(".table-responsive").shouldHave(text("Alex"));
            $(".table-responsive").shouldHave(text("Ivanov"));
            $(".table-responsive").shouldHave(text("Test@mail.ru"));
            $(".table-responsive").shouldHave(text("0123456789"));
            $(".table-responsive").shouldHave(text("14 March,1995"));
            $(".table-responsive").shouldHave(text("History"));
            $(".table-responsive").shouldHave(text("Music"));
            $(".table-responsive").shouldHave(text("Tiraspol"));
            //$(".table-responsive").shouldHave(text("QA.jpg"));
            $(".table-responsive").shouldHave(text("NCR Gurgaon"));
        });
        // File file = $("#uploadPicture").uploadFile(new File("src/test/java/resources/QA.jpg"));

    }
}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Renat");
        $("#lastName").setValue("Taner");
        $("#userEmail").setValue("renat@taner.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9876543210");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $(".react-datepicker__year-select").$(byText("1900")).click();
        $(".react-datepicker__month").$(byText("28")).click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("scubi.jpg");
        $("#currentAddress").setValue("Baikonur Cosmodrome");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Lucknow")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Renat Taner"),
                text("renat@taner.com"),
                text("Other"),
                text("9876543210"),
                text("28 April,1900"),
                text("Commerce"),
                text("Reading"),
                text("scubi.jpg"),
                text("Baikonur Cosmodrome"),
                text("Uttar Pradesh Lucknow"));

    }
}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Freeman");
        $("#userEmail").setValue("freeman@freeman.com");
        $("#currentAddress").setValue("baikonur cosmodrome");
        $("#permanentAddress").setValue("cosmodrome baikonur");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Freeman"));
        $("#output").$("#email").shouldHave(text("freeman@freeman.com"));
        $("#output").$("#currentAddress").shouldHave(text("baikonur cosmodrome"));
        $("#output").$("#permanentAddress").shouldHave(text("cosmodrome baikonur"));

    }
}
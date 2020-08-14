package Junit5.SignUp;

import static com.codeborne.selenide.Selenide.$;

import Junit5.TestBase;
import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingupTest extends TestBase {

  @Story("Open page")
  @DisplayName("Check Esteem page is open after click on 'Sign up'")
  @Test
  public void checkEsteemPageAvailable() {
    feedPage = FeedPage.openFeedPage();
    signUp = header.clickOnSingUp();
    signUp.clickOnSingUpThroughEsteem();
    signUp.switchTabWindowToNext();
    $(".dialog-description-text").shouldBe(Condition.visible)
        .shouldHave(Condition.text("Create an account. Download Esteem! Start earning ESTM and crypto."));
  }

}

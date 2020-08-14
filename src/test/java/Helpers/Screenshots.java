package Helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots {

  @Attachment(value = "Page screenshot", type = "image/png")
  private static byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }

  public static void screenshot() {
    if (WebDriverRunner.getWebDriver() == null) {
      System.out.println("Driver for screenshot not found");
      return;
    }
    saveScreenshot(((TakesScreenshot) WebDriverRunner.getWebDriver())
        .getScreenshotAs(OutputType.BYTES));
  }

}

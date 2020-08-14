package com.wizardsdev;

import com.wizardsdev.Components.Header;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Step;
import java.util.Properties;

// In this class you can write methods for doing some actions
public class Keywords {

  @Step
  public void loginAs(int numberOfUser) {
    FeedPage.openFeedPage();
    Header header = new Header();
    int qaNumber = Context.getQaNumber();
    Properties properties = Context.getInstance().getProperties();
    String login = properties.getProperty(String.format("UserLogin%s%s", qaNumber, numberOfUser));
    String password = properties.getProperty(String.format("LoginPassword%s%s", qaNumber, numberOfUser));
    header.logInWithHiveSigner(login, password);
  }

}

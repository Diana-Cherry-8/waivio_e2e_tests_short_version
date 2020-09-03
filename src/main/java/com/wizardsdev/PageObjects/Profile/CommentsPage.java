package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommentsPage extends ProfilePage {

    private static final By USERNAME_IN_POST_LOCATOR = By.cssSelector(".username");

    public CommentsPage(String userName) {
        super(Context.getSiteUrl()  + "/@" + userName + "/comments");
    }

    @Step
    public static CommentsPage openCommentsPage(String userName) {
        if (!url().contains(Context.getSiteUrl()  + "/@" + userName + "/comments")) {
            open(Context.getSiteUrl()  + "/@" + userName + "/comments");
        }
        return new CommentsPage(userName);
    }

    @Step
    public String getUsernameInPost()
    {
        return $(USERNAME_IN_POST_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {
    }
}

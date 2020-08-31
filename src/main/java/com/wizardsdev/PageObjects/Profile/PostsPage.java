package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PostsPage extends ProfilePage {
    private static final String PAGE_URL = "/@waivio_diana-cherednik"; // здесь адресс профиля
    private static final By BUTTON_SEND_MESSAGE_LOCATOR = By.cssSelector(".QuickComment__send-comment");

    public PostsPage() {
        super(PAGE_URL);
    }

    @Step
    public boolean isButtonSendMessageExist() {
        return $(BUTTON_SEND_MESSAGE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


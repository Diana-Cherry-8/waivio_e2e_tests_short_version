package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditProfilePage extends Page {
    private static final String PAGE_URL = "/edit-profile";
    private static final By BUTTON_CHANGE_AVATAR = By.cssSelector(".Settings__profile-image button"); //вообще показывает 2 кнопки

    public EditProfilePage() {
        super(PAGE_URL);
    }

    @Step
    public EditProfilePage openEditProfilePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new EditProfilePage();
    }

    @Override
    protected void init() {
        String pageUrl = getCurrentPage();
        $(BUTTON_CHANGE_AVATAR).shouldBe(Condition.visible);
        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}


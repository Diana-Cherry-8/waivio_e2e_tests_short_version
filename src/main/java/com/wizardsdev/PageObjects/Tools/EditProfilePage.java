package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.ReservedPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditProfilePage extends Page {
    private static final String PAGE_URL = "/edit-profile";

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
    }

    @Override
    protected void parsePage() {
    }
}


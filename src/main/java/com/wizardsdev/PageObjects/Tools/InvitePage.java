package com.wizardsdev.PageObjects.Tools;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class InvitePage extends Page {
    private static final String PAGE_URL = "/invite";
    private static final By BUTTON_COPY_LINK_LOCATOR = By.cssSelector(".Invite__input__copy");

    public InvitePage() {
        super(PAGE_URL);
    }

    @Step
    public InvitePage openInvitePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new InvitePage();
    }

    @Step
    public String getNameCopyLinkButton() {
        return $(BUTTON_COPY_LINK_LOCATOR).getText();
    }

    @Override
    protected void init() {
//        String pageUrl = getCurrentPage();
//        $(BUTTON_COPY_LINK_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}

package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditorPage extends Page {
    private static final String PAGE_URL = "/editor";

    private static final By BUTTON_READY_TO_PUBLISH_LOCATOR = By.cssSelector(".ant-btn-lg");
    private static final By INPUT_TITLE_EDITOR_LOCATOR = By.cssSelector(".md-RichEditor-title");
    private static final By INPUT_CONTENT_EDITOR_LOCATOR = By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr");
    private static final By CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR = By.cssSelector(".ant-checkbox");
    private static final By BUTTON_PUBLISH_IN_PREVIEW_LOCATOR = By.cssSelector(".edit-post__submit-btn");

    public EditorPage() {
        super(PAGE_URL);
    }

    @Step
    public static EditorPage openEditor() {
        if (!url().equals(Context.getSiteUrl())) {
            open(PAGE_URL);
        }
        return new EditorPage();
    }

    @Step
    public EditorPage setPostTitle(String postTitle) {
        $(INPUT_TITLE_EDITOR_LOCATOR).shouldBe(Condition.visible).setValue(postTitle);
        return this;
    }

    @Step
    public EditorPage setContentPost(String contentPost) {
        $(INPUT_CONTENT_EDITOR_LOCATOR).shouldBe(Condition.visible).sendKeys(contentPost);
        return this;
    }

    @Step
    public EditorPage clickButtonReadyToPublish() {
        $(BUTTON_READY_TO_PUBLISH_LOCATOR).shouldBe(Condition.enabled).click();
        return this;
    }

    @Step
    public SelenideElement getButtonReadyToPublish() {
        return $(BUTTON_READY_TO_PUBLISH_LOCATOR);
    }

    @Step
    public EditorPage clickCheckboxLegalNotice() {
        $(CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public EditorPage clickButtonPublish() {
        $(BUTTON_PUBLISH_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public void postAppearWaiter() {
        sleep(10000);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

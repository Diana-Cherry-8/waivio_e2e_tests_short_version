package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

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
    public void setPostTitle(String postTitle) {
        $(INPUT_TITLE_EDITOR_LOCATOR).shouldBe(Condition.visible).setValue(postTitle);
    }

    @Step
    public void setContentPost(String contentPost) {
        $(INPUT_CONTENT_EDITOR_LOCATOR).shouldBe(Condition.visible).sendKeys(contentPost);
    }

    @Step
    public void clickButtonReadyToPublish() {
        $(BUTTON_READY_TO_PUBLISH_LOCATOR).shouldBe(Condition.enabled).click();
    }

    @Step
    public boolean isButtonReadyToPublishExists() {
        return $(BUTTON_READY_TO_PUBLISH_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public void clickCheckboxLegalNotice() {
        $(CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickButtonPublish() {
        $(BUTTON_PUBLISH_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
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

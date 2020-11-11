package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditorPage extends Page{
    private static final String PAGE_URL = "/editor";

    private static final By BUTTON_READY_TO_PUBLISH_LOCATOR = By.cssSelector(".ant-btn-lg");
    private static final By INPUT_TITLE_EDITOR_LOCATOR = By.cssSelector(".md-RichEditor-title");
    private static final By INPUT_CONTENT_EDITOR_LOCATOR = By.cssSelector(".waiv-editor");
    private static final By CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR = By.cssSelector(".ant-checkbox-input");
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
    public void setPostTitle(String postTitle){
        $(INPUT_TITLE_EDITOR_LOCATOR).shouldBe(Condition.visible).setValue(postTitle);
    }


    @Step
    public void setContentPost(String contentPost) {
        //#TODO
    }

    @Step
    public void clickButtonReadyToPublish() {
        $(BUTTON_READY_TO_PUBLISH_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickCheckboxLegalNotice() {
        $(CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickButtonPublish() {
        $(BUTTON_PUBLISH_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

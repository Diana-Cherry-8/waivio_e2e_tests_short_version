package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditorPage extends Page {
    private static final String PAGE_URL = "/editor";

    private static final By BUTTON_READY_TO_PUBLISH_LOCATOR = By.cssSelector(".ant-btn-lg");
    private static final By INPUT_TITLE_EDITOR_LOCATOR = By.cssSelector(".md-RichEditor-title");
    private static final By INPUT_CONTENT_EDITOR_LOCATOR = By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr");
    private static final By CHECKBOX_LEGAL_NOTICE_IN_PREVIEW_LOCATOR = By.cssSelector(".ant-checkbox");
    private static final By BUTTON_PUBLISH_IN_PREVIEW_LOCATOR = By.cssSelector(".edit-post__submit-btn");
    private static final By BUTTON_CLOSE_MODAL_WINDOW_LOCATOR = By.cssSelector(".ant-modal-close-x");
    private static final By BADGE_SAVED_LOCATOR = By.cssSelector(".ant-badge");
    private static final By SWITCH_OBJECT_CARD_LOCATOR = By.cssSelector(".ant-switch-checked");

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
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(1).shouldBe(Condition.visible).sendKeys(contentPost);
    }

    @Step
    public void clickButtonReadyToPublish() {
        $(BADGE_SAVED_LOCATOR).shouldBe(Condition.visible);
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
    public PostsPage clickButtonPublish(String userName) {
        sleep(2000);
        $(BUTTON_PUBLISH_IN_PREVIEW_LOCATOR).shouldBe(Condition.visible).click();
        if($$(BUTTON_CLOSE_MODAL_WINDOW_LOCATOR).get(1).exists()){
            $$(BUTTON_READY_TO_PUBLISH_LOCATOR).get(2).shouldBe(Condition.visible).click();
        }
        return new PostsPage(userName);
    }

    @Step
    public void clickOnObjectSwitch() {
        $$(SWITCH_OBJECT_CARD_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public void clearContentPost() {
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0).shouldBe(Condition.visible).doubleClick();
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(1).shouldBe(Condition.visible).clear();
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(4).shouldBe(Condition.visible).clear();
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(5).shouldBe(Condition.visible).clear();
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(6).shouldBe(Condition.visible).clear();
    }
    @Step
    public void clickClosePreviewModalWindow() {
        $$(BUTTON_CLOSE_MODAL_WINDOW_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

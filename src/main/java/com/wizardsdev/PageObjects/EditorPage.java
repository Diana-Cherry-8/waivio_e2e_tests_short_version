package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.Modals.AddImages;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import io.qameta.allure.Step;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


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
    private static final By BUTTON_PLUS_LOCATOR = By.cssSelector(".md-sb-button");
    private static final By BUTTONS_IN_PLUS_BUTTON_LOCATOR = By.cssSelector(".action-btn__caption");

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
        sleep(3000);
        $(INPUT_TITLE_EDITOR_LOCATOR).shouldBe(Condition.visible).setValue(postTitle);
    }

    @Step
    public void setContentPost(String contentPost) {
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0).shouldBe(Condition.visible).sendKeys(contentPost);
    }

    @Step
    public void setContentPostForEdit(String contentPost) {
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0).shouldBe(Condition.visible).sendKeys(contentPost);
    }

    @Step
    public void clickButtonReadyToPublish() {
        $(BADGE_SAVED_LOCATOR).shouldBe(Condition.visible);
        sleep(3000);
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
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0)
            .shouldBe(Condition.visible)
            .sendKeys(Keys.CONTROL + "a");
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0).shouldBe(Condition.visible).sendKeys(Keys.DELETE);
    }
    @Step
    public void clickClosePreviewModalWindow() {
        $$(BUTTON_CLOSE_MODAL_WINDOW_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickPlusButton() {
        $(BUTTON_PLUS_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public AddImages clickPhotoButtonInPlusLocator() {
        $$(BUTTONS_IN_PLUS_BUTTON_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return new AddImages();
    }

    @Step
    public void savePictureLinkToClipboard() throws IOException, UnsupportedFlavorException {
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0)
            .shouldBe(Condition.visible)
            .sendKeys(Keys.CONTROL + "a");
        $$(INPUT_CONTENT_EDITOR_LOCATOR).get(0)
            .shouldBe(Condition.visible)
            .sendKeys(Keys.CONTROL + "x");
        String localClipboardData = (String) Toolkit.getDefaultToolkit()
            .getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

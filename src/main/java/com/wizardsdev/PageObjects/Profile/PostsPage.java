package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.EditorPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PostsPage extends ProfilePage {
    private static final By BUTTON_SEND_MESSAGE_LOCATOR = By.cssSelector(".QuickComment__send-comment");
    private static final By FEED_POST_LOCATOR = By.cssSelector(".profile");
    private static final By POST_TITLE_LOCATOR = By.cssSelector(".Story__content h2");
    private static final By ITEM_EDIT_POST_IN_TREE_DOTS_MENU_LOCATOR =
        By.cssSelector(".PopoverMenuItem .icon-write");
    private static final By TREE_DOTS_BUTTON_LOCATOR = By.cssSelector(".Buttons__post-menu");
    private static final By CONTAINER_FOR_IMAGE_LOCATOR = By.cssSelector(".Story__content__img-container");
    private static final By POST_LOCATOR = By.cssSelector(".Story__content");
    private static final By CONTENT_BODY_LOCATOR = By.cssSelector(".Story__content__body");


    public PostsPage(String userName) {
        super(Context.getSiteUrl() + "/@" + userName);
    }

    @Step
    public static PostsPage openPostsPage(String userName) {
        if (!url().contains(Context.getSiteUrl() + "/@" + userName)) {
            open(Context.getSiteUrl() + "/@" + userName);
        }
        return new PostsPage(userName);
    }

    @Step
    public boolean isButtonSendMessageExist() {
        return $(BUTTON_SEND_MESSAGE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getPostTitle(int postIndex) {
        return $$(POST_TITLE_LOCATOR).get(postIndex).getText();
    }

    @Step
    public void postAppearWaiter() {
        sleep(15000);
    }

    @Step
    public void clickOnTreeDotsButton(int index) {
        $$(TREE_DOTS_BUTTON_LOCATOR).get(index).shouldBe(Condition.visible).click();
    }

    @Step
    public EditorPage clickOnEditPostInPostMenu() {
        clickOnTreeDotsButton(0);
        $(ITEM_EDIT_POST_IN_TREE_DOTS_MENU_LOCATOR).shouldBe(Condition.visible).click();
        return new EditorPage();
    }

    @Step
    public boolean isImageContainerExist() {
        return $$(POST_LOCATOR).get(0).find(CONTAINER_FOR_IMAGE_LOCATOR).exists();
    }

    @Step
    public String  getContentBody() {
        return $$(CONTENT_BODY_LOCATOR).get(0).getText();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


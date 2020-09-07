package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ExpertisePage extends ProfilePage {
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER_LOCATOR = By.cssSelector(".Follow--secondary");
    private static final By TEXT_NO_DATA_HASHTAGS_LOCATOR = By.cssSelector(".ObjectDynamicList__empty");
    private static final By LINKS_USER_EXPERTISE_ITEM_LOCATOR = By.cssSelector(".UserExpertise__item");
    private static final By FEED_HASHTAGS_EXPERTISE_LOCATOR = By.cssSelector(".UserExpertise");

    public ExpertisePage(String userName) {
        super(Context.getSiteUrl()  + "/@" + userName + "/expertise");
    }

    @Step
    public static ExpertisePage openExpertisePage(String userName) {
        if (!url().contains(Context.getSiteUrl()  + "/@" + userName + "/expertise")) {
            open(Context.getSiteUrl()  + "/@" + userName + "/expertise");
        }
        return new ExpertisePage(userName);
    }

    @Step
    public boolean isButtonFollowObjectExist() {
        return $(BUTTON_FOLLOW_FOLLOWERS_USER_LOCATOR).exists();
    }

    @Step
    public String getTextNoDataHashtagsTab() {
        return $(TEXT_NO_DATA_HASHTAGS_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public boolean getUserExpertiseFeed() {
        return $(FEED_HASHTAGS_EXPERTISE_LOCATOR).exists();
    }


    public void clickOnExpertiseItemsLinkByIndex(int index){
        $$(LINKS_USER_EXPERTISE_ITEM_LOCATOR).get(index).click();
    }

    @Step
    public ExpertisePage clickOnObjectsExpertiseItem() {
        clickOnExpertiseItemsLinkByIndex(1);
        return new ExpertisePage(getUserNameValue());
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Tools.DraftsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ExpertisePage extends Page {
    private static final String PAGE_URL = "/@waivio_diana-ch/expertise";
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER_LOCATOR = By.cssSelector(".Follow--secondary");
    private static final By TEXT_NO_DATA_HASHTAGS_LOCATOR = By.cssSelector(".ObjectDynamicList__empty");
    private static final By LINKS_USER_EXPERTISE_ITEM_LOCATOR = By.cssSelector(".UserExpertise__item");

    public ExpertisePage() {
        super(PAGE_URL);
    }

    @Step
    public static ExpertisePage openExpertisePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ExpertisePage();
    }

    @Step
    public boolean isButtonFollowObjectExist() {
        return $(BUTTON_FOLLOW_FOLLOWERS_USER_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getTextNoDataHashtagsTab() {
        return $(TEXT_NO_DATA_HASHTAGS_LOCATOR).shouldBe(Condition.visible).getText();
    }

    public static void clickOnHashtagsOrObjectsExpertiseLinkByIndex(int index){
        $$(LINKS_USER_EXPERTISE_ITEM_LOCATOR).get(index).click();
    }

    @Step
    public ExpertisePage clickOnObjectsExpertiseItem() {
        clickOnHashtagsOrObjectsExpertiseLinkByIndex(1);
        return new ExpertisePage();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


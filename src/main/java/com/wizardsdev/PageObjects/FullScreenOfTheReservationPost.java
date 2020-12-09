package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FullScreenOfTheReservationPost extends Page{
    private static final By TITLE_REWARDS_RESERVATIONS_LOCATOR = By.cssSelector(".StoryFull__title");
    private static final By CENTRAL_FEED_IN_PAGE_LOCATOR = By.cssSelector(".Body--full");

    @Step
    public String getTitleRewardsReservations()
    {
        return $(TITLE_REWARDS_RESERVATIONS_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public String getContentPage() {
        return $(CENTRAL_FEED_IN_PAGE_LOCATOR).shouldHave(Condition.visible).getText();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

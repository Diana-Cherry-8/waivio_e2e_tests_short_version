package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.FullScreenOfTheReservationPost;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HistoryPage extends Page {
    private static final String PAGE_URL = "/rewards/history";
    private static final By BUTTONS_THREE_POINTS_LOCATOR = By.cssSelector(".icon-more");
    private static final By ITEM_VIEW_RESERVATION_LOCATOR = By.cssSelector(".PopoverMenuItem");

    public HistoryPage() {
        super(PAGE_URL);
    }

    @Step
    public static HistoryPage openHistoryPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new HistoryPage();
    }

    @Step
    public void clickButtonMore() {
        $$(BUTTONS_THREE_POINTS_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public FullScreenOfTheReservationPost clickOnItemViewReservation() {
        $(ITEM_VIEW_RESERVATION_LOCATOR).shouldBe(Condition.visible).click();
        return new FullScreenOfTheReservationPost();
    }


    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
//        String pageUrl = getCurrentPage();
//        $(TITLE_REWARDS_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}

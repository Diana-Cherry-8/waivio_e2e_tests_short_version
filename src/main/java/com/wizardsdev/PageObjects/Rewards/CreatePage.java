package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreatePage extends Page {
    private static final String PAGE_URL = "/rewards/create";
    private static final By TITLE_CAMPAIGN_NAME_LOCATOR = By.cssSelector(".CreateReward__second");

    public CreatePage() {
        super(PAGE_URL);
    }

    @Step
    public static CreatePage openCreatePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new CreatePage();
    }

    @Step
    public String getTitleCampaignName()
    {
        return $(TITLE_CAMPAIGN_NAME_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

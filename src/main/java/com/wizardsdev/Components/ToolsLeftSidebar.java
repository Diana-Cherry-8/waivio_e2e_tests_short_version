package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.NotificationsPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.*;
import com.wizardsdev.PageObjects.Tools.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ToolsLeftSidebar extends Page {
    private static final By SIDE_BAR_ITEMS_LINK_TOOLS_LOCATOR = By.cssSelector(".sidenav-discover-objects__item");

    public ToolsLeftSidebar() {
        super();
    }

    public static ToolsLeftSidebar initToolsLeftSidebar() {
        return new ToolsLeftSidebar();
    }

    public void clickOnSideBarItemToolsByName(String itemName){
        $$(SIDE_BAR_ITEMS_LINK_TOOLS_LOCATOR).findBy(Condition.text(itemName)).click();
    }
    public static void clickOnSideBarItemRewardsByIndex(int index){
        $$(SIDE_BAR_ITEMS_LINK_TOOLS_LOCATOR).get(index).click();
    }

    @Step
    public DraftsPage clickOnDraftsItem() {
        clickOnSideBarItemRewardsByIndex(0);
        return new DraftsPage();
    }

    @Step
    public BookmarksPage clickOnBookmarksItem() {
        clickOnSideBarItemRewardsByIndex(1);
        return new BookmarksPage();
    }

    @Step
    public EditProfilePage clickOnEditProfileItems() {
        clickOnSideBarItemRewardsByIndex(2);
        return new EditProfilePage();
    }

    @Step
    public SettingsPage clickOnSettingsItem() {
        clickOnSideBarItemRewardsByIndex(3);
        return new SettingsPage();
    }

    @Step
    public GuestsSettingsPage clickOnGuestsSettingsItem() {
        clickOnSideBarItemRewardsByIndex(4);
        return new GuestsSettingsPage();
    }

    @Step
    public NotificationsPageTools clickOnNotificationsItem() {
        clickOnSideBarItemRewardsByIndex(5);
        return new NotificationsPageTools();
    }

    @Step
    public InvitePage clickOnInviteItem() {
        clickOnSideBarItemRewardsByIndex(6);
        return new InvitePage();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


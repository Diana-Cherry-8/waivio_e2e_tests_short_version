package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Tools.*;
import com.wizardsdev.PageObjects.Tools.Website.AdministratorsPage;
import com.wizardsdev.PageObjects.Tools.Website.AreasPage;
import com.wizardsdev.PageObjects.Tools.Website.AuthoritiesPage;
import com.wizardsdev.PageObjects.Tools.Website.ConfigurationWebsitePage;
import com.wizardsdev.PageObjects.Tools.Website.ModeratorsPage;
import com.wizardsdev.PageObjects.Tools.Website.MutedUsersPage;
import com.wizardsdev.PageObjects.Tools.Website.ObjectsFiltersPage;
import com.wizardsdev.PageObjects.Tools.Website.SettingsWebsitePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ToolsLeftSidebar extends Page {
    private static final By SIDE_BAR_ITEMS_LINK_TOOLS_LOCATOR =
        By.cssSelector(".sidenav-discover-objects__item");

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
    public ToolsNotificationsPage clickOnNotificationsItem() {
        clickOnSideBarItemRewardsByIndex(0);
        return new ToolsNotificationsPage();
    }

    @Step
    public DraftsPage clickOnDraftsItem() {
        clickOnSideBarItemRewardsByIndex(1);
        return new DraftsPage();
    }

    @Step
    public BookmarksPage clickOnBookmarksItem() {
        clickOnSideBarItemRewardsByIndex(2);
        return new BookmarksPage();
    }

    @Step
    public EditProfilePage clickOnEditProfileItems() {
        clickOnSideBarItemRewardsByIndex(3);
        return new EditProfilePage();
    }

    @Step
    public SettingsPage clickOnSettingsItem() {
        clickOnSideBarItemRewardsByIndex(4);
        return new SettingsPage();
    }

    @Step
    public GuestsSettingsPage clickOnGuestsSettingsItem() {
        clickOnSideBarItemRewardsByIndex(5);
        return new GuestsSettingsPage();
    }

    @Step
    public NewAccountsPage clickOnNewAccountsAsGuest() {
        clickOnSideBarItemRewardsByIndex(6);
        return new NewAccountsPage();
    }

    @Step
    public InvitePage clickOnInviteItemAsGuest() {
        clickOnSideBarItemRewardsByIndex(7);
        return new InvitePage();
    }

    @Step
    public NewAccountsPage clickOnNewAccountsAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(5);
        return new NewAccountsPage();
    }

    @Step
    public InvitePage clickOnInviteItemAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(6);
        return new InvitePage();
    }

    @Step
    public CreateWebsitePage clickOnCreateWebsite() {
        clickOnSideBarItemRewardsByIndex(7);
        return new CreateWebsitePage();
    }

    @Step
    public ManageWebsitePage clickOnManageWebsite() {
        clickOnSideBarItemRewardsByIndex(8);
        return new ManageWebsitePage();
    }

    @Step
    public ReportsWebsitePage clickOnReportsWebsite() {
        clickOnSideBarItemRewardsByIndex(9);
        return new ReportsWebsitePage();
    }

    @Step
    public ConfigurationWebsitePage clickOnConfigurationWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(10);
        return new ConfigurationWebsitePage(websiteName, template);
    }

    @Step
    public SettingsWebsitePage clickOnSettingsWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(11);
        return new SettingsWebsitePage(websiteName, template);
    }

    @Step
    public AdministratorsPage clickOnAdministratorsWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(12);
        return new AdministratorsPage(websiteName, template);
    }

    @Step
    public ModeratorsPage clickOnModeratorsWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(13);
        return new ModeratorsPage(websiteName, template);
    }

    @Step
    public AuthoritiesPage clickOnAuthoritiesWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(14);
        return new AuthoritiesPage(websiteName, template);
    }

    @Step
    public AreasPage clickOnAreasWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(15);
        return new AreasPage(websiteName, template);
    }

    @Step
    public ObjectsFiltersPage clickOnObjectsFiltersWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(16);
        return new ObjectsFiltersPage(websiteName, template);
    }

    @Step
    public MutedUsersPage clickOnMutedUsersWebsite(String websiteName, String template) {
        clickOnSideBarItemRewardsByIndex(17);
        return new MutedUsersPage(websiteName, template);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


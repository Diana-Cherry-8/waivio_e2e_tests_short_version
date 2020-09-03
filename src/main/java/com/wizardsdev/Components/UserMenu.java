package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.AboutPage;
import com.wizardsdev.PageObjects.DiscoverPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import com.wizardsdev.PageObjects.Tools.NotificationsPageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserMenu extends Page {
    private static final By USER_MENU_ITEMS_LOCATOR = By.className("Topnav__link");

    protected UserMenu() {
        super();
    }

    public static UserMenu initUserMenu() {
        return new UserMenu();
    }

//    @Step
//    public WebElement getUserMenuItemByNumber(int itemNumber) {
//        return  $$(USER_MENU_ITEMS_LOCATOR).get(itemNumber).shouldBe(Condition.visible);
//    }
//
//    @Step
//    public DiscoverPage clickOnDiscoverItem() {
//        getTopNavigationItemByNumber(2).click();
//        return new DiscoverPage();
//    }
//
//    @Step
//    public EligiblePage clickOnRewardsItem() {
//        getTopNavigationItemByNumber(1).click();
//        return new EligiblePage();
//    }
//
//    @Step
//    public NotificationsPageTools clickOnToolsItem() {
//        getTopNavigationItemByNumber(3).click();
//        return new NotificationsPageTools();
//    }
//
//    @Step
//    public AboutPage clickOnAboutItem() {
//        getTopNavigationItemByNumber(4).click();
//        return new AboutPage();
//    }



    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


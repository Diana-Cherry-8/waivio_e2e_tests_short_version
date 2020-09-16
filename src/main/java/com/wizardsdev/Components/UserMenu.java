package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$$;

import com.wizardsdev.PageObjects.Page;
import org.openqa.selenium.By;

public class UserMenu extends Page {
    private static final By USER_MENU_ITEMS_LOCATOR = By.className("Topnav__link");

    protected UserMenu() {
        super();
    }

    public static UserMenu initUserMenu() {
        return new UserMenu();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


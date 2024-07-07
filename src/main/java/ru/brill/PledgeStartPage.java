package ru.brill;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PledgeStartPage {

    private final Page page;
    private final Locator tab;

    public PledgeStartPage(Page page) {
        this.page = page;
        this.tab = page.locator("//a[text()='По информации о залогодателе']");
    }

    public void navigate() {
        page.navigate(ConfigProperties.getProperty("person_info_page"));
    }

    public void click() {
        tab.click();
    }
}

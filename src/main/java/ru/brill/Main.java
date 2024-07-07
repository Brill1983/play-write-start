package ru.brill;

import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Задать таймауты, развернуть страницу на максимум
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
            Page page = context.newPage();

            PledgeStartPage startPage = new PledgeStartPage(page);
            startPage.navigate();
            startPage.click();

            // ИГОРЬ СТАНИСЛАВОВИЧ КИМ, 12.06.1971
            PersonInfoPage personInfoPage = new PersonInfoPage(page);
            personInfoPage.setLastName("Ким");
            personInfoPage.setFirstName("Игорь");
            personInfoPage.setFatherName("Станиславович");
            personInfoPage.setBirthday("12.06.1971");
            personInfoPage.pushFindButton();
        }
    }
}
package ru.brill;

import org.junit.jupiter.api.BeforeAll;

public class PledgePersonInfoPageTest {

    @BeforeAll
    static void init() {

        //Test Isolation
        //Playwright has the concept of a BrowserContext which is an in-memory isolated browser profile.
        // It's recommended to create a new BrowserContext for each test to ensure they don't interfere with each other.
        //
        //Browser browser = playwright.chromium().launch();
        //BrowserContext context = browser.newContext();
        //Page page = context.newPage();
    }

//      @BeforeAll
//  static void launchBrowser() {
//    playwright = Playwright.create();
//    browser = playwright.chromium().launch();
//  }
//
//  @AfterAll
//  static void closeBrowser() {
//    playwright.close();
//  }
//
//  @BeforeEach
//  void createContextAndPage() {
//    context = browser.newContext();
//    page = context.newPage();
//  }
//
//  @AfterEach
//  void closeContext() {
//    context.close();
//  }
}

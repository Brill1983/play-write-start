package ru.brill;

import com.microsoft.playwright.*;
import ru.brill.dto.PledgeResultDto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext context = browser.newContext(/*new Browser.NewContextOptions().setViewportSize(1920, 1080)*/);
            Page page = context.newPage();
            PledgeStartPage startPage = new PledgeStartPage(page);
            startPage.navigate();
            startPage.click();
            // ИГОРЬ СТАНИСЛАВОВИЧ КИМ, 12.06.1971
            PersonInfoPage personInfoPage = new PersonInfoPage(page);
            personInfoPage.setLastName("Ким");
            personInfoPage.setFirstName("Игорь");
//            personInfoPage.setFatherName("Станиславович");
            personInfoPage.setFatherName("Вячеславович");
//            personInfoPage.setBirthday("12.06.1971");
            personInfoPage.setBirthday("22.03.1979");
            personInfoPage.pushFindButton();

            PledgeResultPage resultPage = new PledgeResultPage(page);
            PledgeResultDto receivedResult = resultPage.getResult();
            List<List<String>> results = receivedResult.getResult();
            int n = 0;
            for (List<String> result : results) {
                n++;
                System.out.println(" RESULT # " + n);
                for (String s : result) {
                    System.out.println(s);
                }
            }
        }
    }
}
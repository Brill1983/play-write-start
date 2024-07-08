package ru.brill;

import com.microsoft.playwright.*;
import org.apache.commons.lang3.StringUtils;
import ru.brill.dto.PersonInfoDto;
import ru.brill.dto.PledgeResultDto;

import static ru.brill.utils.Constants.DATE_FORMATTER;

public class PledgeServiceImpl implements PledgeService {

    @Override
    public PledgeResultDto getPledgeList(PersonInfoDto person) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
            Page page = context.newPage();
            PledgeStartPage startPage = new PledgeStartPage(page);
            startPage.navigate();
            startPage.click();
            // ИГОРЬ СТАНИСЛАВОВИЧ КИМ, 12.06.1971
            PersonInfoPage personInfoPage = new PersonInfoPage(page);
            personInfoPage.setLastName(person.getLastName());
            personInfoPage.setFirstName(person.getFirstName());
            if (StringUtils.isNotBlank(person.getFatherName())) personInfoPage.setFatherName(person.getFatherName());
            personInfoPage.setBirthday(person.getBirthday().format(DATE_FORMATTER));
//            personInfoPage.setLastName("Ким");
//            personInfoPage.setFirstName("Игорь");
//            personInfoPage.setFatherName("Станиславович");
//            personInfoPage.setFatherName("Вячеславович");
//            personInfoPage.setBirthday("12.06.1971");
//            personInfoPage.setBirthday("22.03.1979");
            personInfoPage.pushFindButton();

            PledgeResultPage resultPage = new PledgeResultPage(page);
            return resultPage.getResult();
        }
    }
}

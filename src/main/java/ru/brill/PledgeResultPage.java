package ru.brill;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ru.brill.dto.PledgeResultDto;

import java.util.ArrayList;
import java.util.List;

import static ru.brill.utils.Constants.IP_RESTRICTED;
import static ru.brill.utils.Constants.NOTHING_FOUND;

public class PledgeResultPage {

    private final Page page;
    private final Locator searchParam;
    private final Locator noResultFound;
    private final Locator resultTable;

    public PledgeResultPage(Page page) {
        this.page = page;
        this.searchParam = page.locator("//div[@class='search-params-tip']");
        this.noResultFound = page.locator("//div[@class='search-error-label']");
        this.resultTable = page.locator("//table/tbody");
    }

    public String searchParams() {
        return searchParam.textContent();
    }

    public PledgeResultDto getResult() {
        searchParam.isEnabled();
        List<List<String>> results = new ArrayList<>();
        PledgeResultDto result = new PledgeResultDto();

        if (noResultFound.isVisible()) {
            String resultStr = noResultFound.textContent().trim();
            results.add(List.of(resultStr));
            result.setResult(results);

            if (resultStr.equals(NOTHING_FOUND)) {
                result.setIsFound(false);
                result.setIsIpRestricted(false);
            } else if (resultStr.equals(IP_RESTRICTED)) {
                result.setIsFound(false);
                result.setIsIpRestricted(true);
            }
            result.setIsFound(false);
            return result;
        }

        if (resultTable.isEnabled()) {
            List<Locator> trList = resultTable.locator("//tr").all();
            for (Locator trLocator : trList) {
                List<String> oneResult = trLocator.locator("//td").all().stream()
                        .map(locator -> locator.textContent().trim().replaceAll("\\n", ""))
                        .toList();
                results.add(oneResult);
            }
            result.setResult(results);
            result.setIsFound(true);
            return result;
        }
        return result;
    }
}

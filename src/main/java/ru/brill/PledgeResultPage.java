package ru.brill;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<String>> getResult() {
        searchParam.isEnabled();
        List<List<String>> results = new ArrayList<>();

        if (noResultFound.isVisible()) {
            results.add(List.of(noResultFound.textContent().trim()));
            return results;
        }

        if (resultTable.isEnabled()) {
            List<Locator> trList = resultTable.locator("//tr").all();
            for (Locator trLocator : trList) {
                List<String> oneResult = trLocator.locator("//td").all().stream()
                        .map(locator -> locator.textContent().trim().replaceAll("\\n", ""))
                        .toList();
                results.add(oneResult);
            }
            return results;
        }
        return results;
    }
}

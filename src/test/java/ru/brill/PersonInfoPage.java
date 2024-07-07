package ru.brill;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PersonInfoPage {

    private final Page page;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator fatherName;
    private final Locator birthday;
    private Locator region;
    private final Locator passport;
    private final Locator findButton;

    public PersonInfoPage(Page page) {
        this.page = page;
        this.firstName = page.locator("//input[@id='privatePerson.firstName']");
        this.lastName = page.locator("//input[@id='privatePerson.lastName']");
        this.fatherName = page.locator("//input[@id='privatePerson.middleName']");
        this.birthday = page.locator("//input[@id='privatePerson.birthday']");
        this.region = page.locator("//span[@dir='ltr']");
        this.passport = page.getByPlaceholder("Серия и номер");
        this.findButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Найти"));
    }

    public void setFirstName(String firstNameStr) {
        firstName.fill(firstNameStr);
    }

    public void setLastName(String lastNameStr) {
        lastName.fill(lastNameStr);
    }

    public void setFatherName(String fatherNameStr) {
        fatherName.fill(fatherNameStr);
    }

    public void setBirthday(String birthdayStr) {
        birthday.fill(birthdayStr);
    }

    public void setPassport(String passportStr) {
        passport.fill(passportStr);
    }

    public void pushFindButton() {
        findButton.click();
    }
}

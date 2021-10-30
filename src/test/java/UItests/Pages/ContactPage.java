package UItests.Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ContactPage extends PageObject {

    public final By contactHeader = By.id("header-message");
    public final By forenameTextField=By.id("forename");
    public final By emailTextField=By.id("email");
    public final By messageTextField=By.id("message");
    public final By submitBtn=By.linkText("Submit");
    public final String successMessage= ".alert.alert-success";
    public final String progressBar=".progress.progress-info.wait";

}

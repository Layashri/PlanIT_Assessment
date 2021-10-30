package UItests.Actions;

import Base.BaseUIInteractions;
import UItests.Pages.ContactPage;
import net.thucydides.core.annotations.Step;

public class ContactPageActions extends BaseUIInteractions {
    ContactPage contactPage;

    public void waitForContactPageLoading(){
        waitElementTobeDisplayed($(contactPage.contactHeader));
    }
    public void enterForename(String name){
        $(contactPage.forenameTextField).sendKeys(name);
    }
    public void enterEmailId(String email){
        $(contactPage.emailTextField).sendKeys(email);
    }
    public void enterMessage(String message){
        $(contactPage.messageTextField).sendKeys(message);
    }

    @Step
    public void submitFeedback(){
        $(contactPage.submitBtn).click();
    }

    @Step
    public String getSuccessMessage(){
        waitElementTobeDisplayed($(contactPage.successMessage));
       return  $(contactPage.successMessage).getText();
    }
}

package UItests.Actions;

import Base.BaseUIInteractions;
import UItests.Pages.CartPage;
import UItests.Pages.JupiterHomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import UItests.Pages.JupiterHomePage;


public class HomePageActions extends BaseUIInteractions {

  JupiterHomePage jupiterhomepage;
  CartPage cartPage;

     @Step
    public void OpenJupiterHomePage()
     {
     jupiterhomepage.open();
     getDriver().manage().window().maximize();
     }

     public boolean validateHomePageLanding(){
     isOptionalElementPresent($(jupiterhomepage.homePageHeading));
     return $(jupiterhomepage.homePageHeading).isPresent();
     }

  @Step
     public void clickContactLink(){
        $(jupiterhomepage.contactLink).click();
     }
  @Step
     public void navigateToShop(){
     $(jupiterhomepage.shopLink).click();
     }

 @Step
 public void navigateToCart()
 {

  $(jupiterhomepage.cartLink).click();
   waitElementTobeDisplayed($(cartPage.cartPageCheck));
 }

}

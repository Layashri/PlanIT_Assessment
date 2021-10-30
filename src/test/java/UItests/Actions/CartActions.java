package UItests.Actions;

import Base.BaseUIInteractions;
import UItests.Pages.CartPage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.platform.commons.util.StringUtils;

public class CartActions extends BaseUIInteractions {

    CartPage cartPage;

    public String getItemQuantity(String toyName){
        return $(cartPage.cartItemBase+toyName+cartPage.cartItemQuantity).getAttribute("value");
    }

    @Step
    public Double getSubTotalOf(String toyName){
        return Double.valueOf($(cartPage.cartItemBase+toyName+cartPage.cartSubTotal)
                .getText()
                .trim()
                .substring(1));
    }

    @Step
    public boolean getItemQuantity(String toyName, Integer quantity){
        Integer numberOfItems =Integer.valueOf($(cartPage.cartItemBase+toyName+cartPage.cartItemQuantity)
                .getAttribute("value"));
        return quantity.equals(numberOfItems);
    }

    @Step
    public boolean subTotalValidation(String toyName, Integer quantity){
        Double unit=Double.valueOf($(cartPage.cartItemBase+toyName+cartPage.cartUnitPrice)
                .getText()
                .trim()
                .substring(1));
      Double subTotalTobe=unit*quantity;
      Double subTotalIs=getSubTotalOf(toyName);
      LOGGER.info(quantity+" of "+toyName+" Unit price is $"+unit+" subtotal is $"+subTotalIs);
      return subTotalTobe.equals(subTotalIs);
    }
}

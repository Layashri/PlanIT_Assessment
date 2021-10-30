package UItests.Actions;

import Base.BaseUIInteractions;
import UItests.Pages.ShopPage;
import net.thucydides.core.annotations.Steps;
import org.apache.bcel.generic.ATHROW;

public class ShopActions extends BaseUIInteractions {


    ShopPage shopPage;

    public void addToy(String toyName){
        $(shopPage.buyBtn+toyName+shopPage.buyBtn2)
                .waitUntilPresent()
                .click();
    }

    public void addToy(String toyName,Integer quantity)  {
        if (quantity > 0) {
            for (int i = 1; i <= quantity; i++) {
                $(shopPage.buyBtn + toyName + shopPage.buyBtn2)
                        .waitUntilPresent()
                        .click();
            }
        } else {
            throw new RuntimeException("Invalid quantity");
        }
    }



}

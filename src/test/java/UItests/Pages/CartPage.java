package UItests.Pages;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {
    public final String cartPageCheck = ".cart-msg";
    public final String cartItemBase = "//td[normalize-space()='";
    public final String cartItemQuantity = "']/..//input";
    public final String cartUnitPrice= "']/parent::tr//td[2]";
    public final String cartSubTotal="']/parent::tr//td[4]";
}

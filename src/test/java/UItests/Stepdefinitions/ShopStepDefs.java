package UItests.Stepdefinitions;

import UItests.Actions.CartActions;
import UItests.Actions.ShopActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopStepDefs {

    Map<String,Integer> toyList;
    List<Boolean> cartList=new ArrayList<>();
    List<Boolean> cartSubTotal=new ArrayList<>();

    ShopActions shopActions;
    CartActions cartActions;

    @And("user adds the below items in cart")
    public void userAddsTheBelowItemsInCart(DataTable addItems) {
     toyList=addItems.asMap(String.class,Integer.class);
      toyList.forEach((k,v)-> shopActions.addToy(k,v));
    }

    @Then("user verifies added items in the cart")
    public void userVerifiesAddedItemsInTheCart() {
        toyList.forEach((k,v)->
                        cartList.add(cartActions.getItemQuantity(k,v)));
        assertThat("Validate added items are present in cart",cartList,everyItem(is(true)));
    }


    @Then("user validates the subtotal of the added items in cart")
    public void userValidatesTheSubtotal() {
        toyList.forEach((k,v)->
                cartSubTotal.add(cartActions.subTotalValidation(k,v)));
        assertThat("Validate added items are present in cart",cartSubTotal,everyItem(is(true)));
    }
}

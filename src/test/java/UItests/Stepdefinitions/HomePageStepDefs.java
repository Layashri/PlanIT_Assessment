package UItests.Stepdefinitions;

import UItests.Actions.ContactPageActions;
import UItests.Actions.HomePageActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.awaitility.Awaitility.await;
import static org.fluentlenium.core.filter.MatcherConstructor.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;

import java.util.List;
import java.util.Map;

public class HomePageStepDefs {

    @Steps
    HomePageActions homePageActions;

    @Steps
    ContactPageActions contactPageActions;

    Map<String, String> fields;

    @Given("user launches the jupiter toys website")
    public void userLaunchesTheJupiterToysWebsite() {
      homePageActions.OpenJupiterHomePage();
    }


    @And("user lands in home page")
    public void userLandsInHomePage() {
        assertThat("Validate Home page Landing",
                homePageActions.validateHomePageLanding(), Is.is(true));
    }

    @Then("user submits feedback with below mandatory information")
    public void userSubmitsFeedback(DataTable mandatoryFields) {
        fields = mandatoryFields.asMap(String.class,String.class);
        contactPageActions.enterForename(fields.get("Forename"));
        contactPageActions.enterEmailId(fields.get("Email"));
        contactPageActions.enterMessage(fields.get("Message"));
        contactPageActions.submitFeedback();
    }

    @Then("user validates successful submission")
    public void userValidatesSubmission() {
        assertThat("Validate Success message",
                contactPageActions.getSuccessMessage().trim(),
                Is.is("Thanks "+fields.get("Forename")+", we appreciate your feedback."));

    }

    @When("user navigates to Contact page")
    public void userNavigatesToContactPage() {
        homePageActions.clickContactLink();
        contactPageActions.waitForContactPageLoading();
    }

    @When("user navigates to shop page")
    public void userNavigatesToShopPage() {
        homePageActions.navigateToShop();

    }
    @And("navigates to cart page")
    public void navigatesToCartPage() {
        homePageActions.navigateToCart();
    }
}

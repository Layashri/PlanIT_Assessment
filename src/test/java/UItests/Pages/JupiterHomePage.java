package UItests.Pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("http://jupiter.cloud.planittesting.com")

public class JupiterHomePage extends PageObject {

    public final String homePageHeading = (".hero-unit");
    public final By contactLink= By.id("nav-contact");
    public final By shopLink=By.id("nav-shop");
    public final By cartLink = By.id("nav-cart");


}

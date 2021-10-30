package Base;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.awaitility.Awaitility.await;


public class BaseUIInteractions extends UIInteractionSteps {

    private EnvironmentVariables environmentVariables;
    protected static final Logger LOGGER= LoggerFactory.getLogger(BaseUIInteractions.class);

    public Predicate<WebElement> isElementDisplayed=WebElement::isDisplayed;
    public  Predicate<WebElementFacade> isElementPresent= WebElementFacade::isPresent;
    public boolean isOptionalElementPresent(WebElement element){
        int defaultTime= 5;
        try{
           wait(element,defaultTime);
            return true;
        }catch(Exception e){
            LOGGER.debug("Element not present");
            return false;
        }

    }

    public void waitUntilElementDisappears(WebElement element){
        int defaultTime=Integer.parseInt(environmentVariables.getProperty("wait.pageload"));

        await(String.format("Waiting for %s to be displayed",nameOf(element)))
                .atMost(defaultTime, TimeUnit.SECONDS)
                .pollDelay(1,TimeUnit.MILLISECONDS)
                .pollInterval(200,TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(()-> ! isElementPresent(element));

    }

    public boolean isVisible(WebElement element){
        try{
            if(this.element(element).isDisplayed()){
                LOGGER.debug("isElementVisible = true: Element- "+nameOf(element));
                return true;
            }else{
                LOGGER.debug("Element Action =false: Element- "+nameOf(element));
                return false;
            }
        }catch(NoSuchElementException e){
            LOGGER.debug("Element Action =false: Element-"+nameOf(element));
            return false;
        }
    }

    public boolean isElementPresent(WebElement element){
        int defaultTime=Integer.parseInt(environmentVariables.getProperty("wait.pageload"));
        try{
            wait(element,defaultTime);
            return true;
        }catch(Exception e){
            LOGGER.debug("Element not present");
            return false;
        }

    }

    private void wait(WebElement element,int n){
            await(String.format("Waiting for %s to be displayed",nameOf(element)))
                    .atMost(n, TimeUnit.SECONDS)
                    .pollDelay(1,TimeUnit.MILLISECONDS)
                    .pollInterval(200,TimeUnit.MILLISECONDS)
                    .ignoreExceptions()
                    .until(()-> isElementDisplayed.test(element));
            LOGGER.info(String.format("Waiting for element %s",nameOf(element)));
    }

    public void waitElementTobeDisplayed(WebElement element){
        int defaultTime=Integer.parseInt(environmentVariables.getProperty("wait.pageload"));
       wait(element,defaultTime);
    }

    private String nameOf(WebElement element){
        try{
            return String.format("[%s]",id(element.toString()));
        }catch (Exception exception){
            return "Not a valid Webelement";
        }
    }

    private static String id(String name){
        name=name.replace("Proxy element for: ","");
        if(name.contains("[[")){
            String sub=name.substring(name.lastIndexOf("[["),name.lastIndexOf("}] -> ")+6);
            name=name.replace(sub,"").replace("]","").trim();
        }
        return name;
    }

}

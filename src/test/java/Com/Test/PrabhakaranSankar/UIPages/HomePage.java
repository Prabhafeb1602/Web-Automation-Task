package Com.Test.PrabhakaranSankar.UIPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends PageObject {


    public void doSearchAndAddToWhisList(String productName){
        waitFor((WebElementFacade) find(By.cssSelector("input[class='header-search-input']")));
        getDriver().get("https://testscriptdemo.com/?product="+productName);
        waitFor((WebElementFacade) find(By.xpath("(//i[@class='yith-wcwl-icon fa fa-heart-o'])[1]")));
        $("(//i[@class='yith-wcwl-icon fa fa-heart-o'])[1]").click();
    }

    public void myWishList(){
        $("(//i[@class='lar la-heart'])[1]").click();
    }

    public void closeCookiePopUp(){
        waitFor((WebElementFacade) find(By.id("cc-window")));
        WebElementFacade element = find(By.cssSelector("a[class='cc-btn cc-accept-all cc-btn-no-href']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

}

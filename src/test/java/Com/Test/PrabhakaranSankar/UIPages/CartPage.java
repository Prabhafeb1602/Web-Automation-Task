package Com.Test.PrabhakaranSankar.UIPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends PageObject {


    public void PageLoadCompleted(){
        waitFor((WebElementFacade) find(By.cssSelector("h1[class='single-title']")));
    }

    public List<WebElementFacade> getProductName(){
        List<WebElementFacade> addToCartButton=  findAll("td[class='product-name'] a");
        return addToCartButton ;
    }

    public void verifyProductAddedToCart(String getProductName){
        String productName = $("td[class='product-name'] a").getText();
        Assert.assertTrue(getProductName.contains(productName));
    }
}

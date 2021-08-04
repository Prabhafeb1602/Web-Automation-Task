package Com.Test.PrabhakaranSankar.Steps;

import Com.Test.PrabhakaranSankar.UIPages.WhishListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WhishListPageSteps {

    private WhishListPage whishListPage;


    @Then("I find total four selected item in my Whishlist")
    public void navigateToWhishListPage(){
        whishListPage.PageLoadCompleted();
        Assert.assertEquals(4, whishListPage.getTotalWishListProduct().size());
    }

    @When("I Search for lowest price product")
    public void searchForLowestPriceProduct(){
        whishListPage.findLowestPriceProduct();
    }

    @Then("I am able to add the lowest price item to my Cart")
    public void addLowestPriceProductToCart(){
        whishListPage.addLowsetPriceItemToCart();
    }
}

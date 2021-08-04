package Com.Test.PrabhakaranSankar.Steps;

import Com.Test.PrabhakaranSankar.UIPages.CartPage;
import Com.Test.PrabhakaranSankar.UIPages.WhishListPage;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class CartPageStep {
    public CartPage cartPage;
    public WhishListPage whishListPage;

    @And("I am able to verify the item in my Cart")
    public void verifyItemInCart(){
        whishListPage.navigateToCartPage();
        cartPage.PageLoadCompleted();
        cartPage.verifyProductAddedToCart(whishListPage.minimumPriceProductName);
    }
}

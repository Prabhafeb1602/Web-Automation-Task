package Com.Test.PrabhakaranSankar.UIPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WhishListPage extends PageObject {

    public static String minimumPriceProductName;
    public static String minimumPrice;

    public String getTitle() {
        return find(By.cssSelector("div[class='wishlist-title wishlist-title-with-form'] h2")).getText();
    }

    public void PageLoadCompleted(){
        waitFor((WebElementFacade) find(By.cssSelector("div[class='wishlist-title wishlist-title-with-form'] h2")));
        Assert.assertTrue(getTitle().contentEquals("My wishlist"));
    }


    public List<WebElementFacade> getTotalWishListProduct(){
        List<WebElementFacade> product=  findAll("td[class='product-price'] ins span[class='woocommerce-Price-amount amount'] bdi");
        return product ;
    }

    public List<WebElementFacade> getSizeAddToCartButtons(){
        List<WebElementFacade> addToCartButton=  findAll("td[class='product-add-to-cart'] a");
        return addToCartButton ;
    }

    public List<WebElementFacade> getProductName(){
        List<WebElementFacade> addToCartButton=  findAll("td[class='product-name'] a");
        return addToCartButton ;
    }


    public void findLowestPriceProduct(){
        int productCount = getTotalWishListProduct().size();
        List<Double> list = new ArrayList<>();
        for (int tot=0; tot<=productCount-1; tot++){
            String removeSpecialCharacter = getTotalWishListProduct().get(tot).getText().replaceAll("[£]", " ");
            list.add(Double.parseDouble(removeSpecialCharacter));
        }
        System.out.println(list);
        Double lowestPriceOfAProduct = Collections.min(list);
        String LowestPrice = Double.toString(lowestPriceOfAProduct);
        minimumPrice=  LowestPrice;
    }

    public void addLowsetPriceItemToCart(){
        int noOfWhishListProductsAvailable = getTotalWishListProduct().size()-1;
        int noOfProd;
        for(noOfProd=0; noOfProd<=noOfWhishListProductsAvailable;noOfProd++){
            String priceValue = getTotalWishListProduct().get(noOfProd).getText().replaceAll("[£]", " ");
            if(priceValue.contains(minimumPrice)){
                minimumPriceProductName= getProductName().get(noOfProd).getText();
                getSizeAddToCartButtons().get(noOfProd).click();
            }
        }
    }

    public void navigateToCartPage(){
        $("( //i[@class='la la-shopping-bag'])[1]").click();
    }

}

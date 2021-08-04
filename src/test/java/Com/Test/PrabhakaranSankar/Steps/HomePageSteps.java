package Com.Test.PrabhakaranSankar.Steps;

import Com.Test.PrabhakaranSankar.UIPages.HomePage;
import Com.Test.PrabhakaranSankar.UIPages.WhishListPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class HomePageSteps {

    private HomePage homePage;


    @Given("^I add four different product to my Whishlist$")
    public void i_add_four_different_product_to_my_whishlist(DataTable testData) throws Throwable{
        homePage.open();
        homePage.closeCookiePopUp();
        List<String> details = testData.asList(String.class);
        int detailsSize = details.size()-1;
        for (int i = 0; i<=detailsSize; i++) {
            homePage.doSearchAndAddToWhisList(details.get(i));
        }
    }

    @When("I view my Whishlist table")
    public void navigateToWhishListPage(){
        homePage.myWishList();
    }
}

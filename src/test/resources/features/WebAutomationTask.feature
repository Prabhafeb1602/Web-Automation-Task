Feature: Web Automation Task

  Scenario: Add Product to WishList
    Given I add four different product to my Whishlist
      | Bikini          |
      | single-shirt    |
      | Modern          |
      | evening-trousers |
    When I view my Whishlist table
    Then I find total four selected item in my Whishlist
    When I Search for lowest price product
    And I am able to add the lowest price item to my Cart
    Then I am able to verify the item in my Cart

Feature: Place the order for products

@PlaceOrder
Scenario Outline: Search a product and verify ability to place order
Given User is on Greenkart landing page
When User search with shortname "<Name>" in Homepage and extracted actual name of the product
And Increase to "<Count>" items of selected product
And Add to cart
Then User proceeds to checkout page and validate the items in checkout page
And Verify the ability of user to enter the promocode and place the order

Examples:
|Name|Count|
|tom|3|
|cap|2|
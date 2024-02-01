Feature: Search and place the order for the products

@SearchProducts
Scenario Outline: Search experience for product search in both Home page and Offers page
Given User is on Greenkart landing page
When User search with shortname "<Name>" in Homepage and extracted actual name of the product
And User search for shortname "<Name>" in Offerspage and extracted actual name of the product
Then Check if the actual product name is same in both Homepage and Offerspage

Examples:
|Name|
|tom|
|cuc|
|bee|
|cap|
|bri|
|man|
|mush|
|wat|
|straw|
|pi|
|wal|
|nuts m|
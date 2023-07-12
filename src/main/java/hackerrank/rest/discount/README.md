# REST API: Discounted Price

Given a _barcode_, query the API at https://jsonmock.hackerrank.com/api/inventory?barcode=barcode and return the 
item's discounted price.

The response is a JSON object with 5 fields. The essential field is data:
* _data_: Either an empty array or an array with a single object that contains the item's record.
* In the data array, the item has the following schema:
  * _barcode_ - the barcode for the product (String)
  * _price_ - the gross selling price (Number)
  * _discount_ - the discount percent to apply (Number).

Some fields that are not of interest.

_page_, _per_page_, _total_, _total_pages_, etc. are not required for this task.

If the barcode is found, the _data_ array contains exactly 1 element. If not, it is empty and the function should 
return '-1'.

An example of the product record from https://jsonmock.hackerrank.com/api/inventory?barcode=74001755 is:
```json
{
 "barcode": "74001755",
 "item": "Ball Gown",
 "category": "Full Body Outfits",
 "price": 785,
 "discount": 7,
 "available": 1
}
```

Use the "discount" and the "price" properties to calculate the discounted price rounded to the nearest integer.

`discountedPrice = price - ((discount / 100) * price)`

## Function Description

Complete the *getDiscountedPrice* function in the editor.

*getDiscountedPrice* has the following parameters:

*string barcode*: the item to query

### Returns

*int*: the discounted price rounded to the nearest integer or -1

### Constraints

There will be either 1 or 0 records in data.

__Note__: Please review the header in the code stub to see available libraries for API requests in the selected 
language. Required libraries can be imported in order to solve the question. Check our full list of supported 
libraries at https://www.hackerrank.com/environment.


# Input Format For Custom Testing

In the first and only line, there is a barcode.

## Samples
### Sample Case 0
#### Input
`74002314`
#### Output
`2964`
#### Explanation
First, a call is made to API https://jsonmock.hackerrank.com/api/inventory?barcode=74002314. The price = 3705 and
discount = 20.


### Sample Case 1
#### Input
`74005364`
#### Output
`-1`
#### Explanation
An API call is made to https://jsonmock.hackerrank.com/api/inventory?barcode=74005364. The data field contains an empty 
array, so the item was not found.
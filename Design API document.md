## Add a product
Request URL : /product/add
RequestMethod : POST
Response Content Parameters :
  {
  "description": "item1",
  "id": 1,
  "price": 200,
  "version": 0
  }
Curl : -
Response Body : Product saved successfully
Response Code : 200

## List all products
Request URL : /product/list
RequestMethod : Get
Response Content Parameters : -
Curl : -
Response Body : 
  {
    "id": 1,
    "version": 0,
    "description": "item1",
    "price": 200
  }
  {
    "id": 2,
    "version": 0,
    "description": "item2",
    "price": 100
  }
Response Code : 200

## Search a product with an ID
Request URL : /product/show/{id}
RequestMethod : Get
Response Content Parameters : {id}
Curl : -
Response Body : 
  {
    "id": 1,
    "version": 0,
    "description": "item1",
    "price": 200
  }
Response Code : 200

## Update a product
Request URL : /product/update/{id}
RequestMethod : PUT
Response Content Parameters : {id} and
  {
  "description": "itemnew1",
  "id": 1,
  "price": 100,
  "version": 0
  }
Curl : -
Response Body : Product updated successfully
Response Code : 200

## Delete a product
Request URL : /product/delete/{id}
RequestMethod : DELETE
Response Content Parameters : {id} 
Curl : -
Response Body : Product deleted successfully
Response Code : 200




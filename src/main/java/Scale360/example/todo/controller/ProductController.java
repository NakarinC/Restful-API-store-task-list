package Scale360.example.todo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Scale360.example.todo.model.Product;
import Scale360.example.todo.model.ProductService;

@RestController
@RequestMapping("/product")
@Api(value="Scale360", description="Scale360 store task list")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @ApiOperation(value = "List all products")
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list(Model model){
        Iterable<Product> productList = productService.listAllProducts();
        return productList;
    }
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable Integer id, Model model){
       Product product = productService.getProductById(id);
        return product;
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
         productService.saveProduct(product);
         return new ResponseEntity<String>("Product saved successfully", HttpStatus.OK);
        
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity<String>("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);

    }

}

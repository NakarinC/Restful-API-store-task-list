package Scale360.example.todo.model;

import Scale360.example.todo.model.Product;;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
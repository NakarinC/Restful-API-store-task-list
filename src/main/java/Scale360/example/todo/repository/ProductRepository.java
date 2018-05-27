package Scale360.example.todo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import Scale360.example.todo.model.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
}

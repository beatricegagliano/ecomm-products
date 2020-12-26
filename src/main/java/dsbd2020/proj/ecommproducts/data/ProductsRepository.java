package dsbd2020.proj.ecommproducts.data;

import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository <Products, Integer> {
}

package dsbd2020.proj.ecommproducts.data;

import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends CrudRepository <Products, Integer>, PagingAndSortingRepository<Products,Integer> {



}

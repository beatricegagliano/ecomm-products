package dsbd2020.proj.ecommproducts.data;

import dsbd2020.proj.ecommproducts.categories.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories,Integer> {
}

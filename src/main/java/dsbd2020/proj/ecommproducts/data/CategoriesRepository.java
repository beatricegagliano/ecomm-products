package dsbd2020.proj.ecommproducts.data;

import dsbd2020.proj.ecommproducts.categories.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriesRepository extends CrudRepository<Categories,Integer>, PagingAndSortingRepository<Categories,Integer> {
}

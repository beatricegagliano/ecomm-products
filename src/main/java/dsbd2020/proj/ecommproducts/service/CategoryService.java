package dsbd2020.proj.ecommproducts.service;

import dsbd2020.proj.ecommproducts.categories.Categories;
import dsbd2020.proj.ecommproducts.data.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
 @Autowired
    CategoriesRepository repository;
    
    public Categories addcategories(Categories categories) {
        return repository.save(categories);
    }

    public Categories getCategories(Integer id) {
        return repository.findById(id).get();
    }

    public Categories updateCateg(Integer id,Categories categories) {
        Optional <Categories> updateCateg = repository.findById(id);
        updateCateg.get().setName(categories.getName());
        return repository.save(categories);
    }

    public String deletebyid(Integer id) {
        repository.deleteById(id);
        return "category deleted";
    }

    public List<Categories> getAllCategories(Integer perPage, Integer page)
    {
        Pageable paging = PageRequest.of(perPage,page);

        Page<Categories> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Categories>();
        }
    }
}

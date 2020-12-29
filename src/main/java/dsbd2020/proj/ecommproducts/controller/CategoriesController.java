package dsbd2020.proj.ecommproducts.controller;

import dsbd2020.proj.ecommproducts.categories.Categories;
import dsbd2020.proj.ecommproducts.data.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CategoriesController {
    @Autowired
    CategoriesRepository repository;

    @PostMapping(path= "/categories")
    public @ResponseBody
    Categories addcategories (@RequestBody Categories categories){
        return repository.save(categories);
    }

    @GetMapping(path="/categories/{id}")
    public @ResponseBody
    Optional<Categories> getCategories (@PathVariable Integer id) {
        return repository.findById(id);
    }

    @GetMapping(path="/categories")
    public @ResponseBody
    Iterable <Categories> getCategoriesAll () {
        return repository.findAll();
    }

    @PutMapping(path="/categories/{id}")
    public @ResponseBody
    Categories updateCateg (@PathVariable Integer id,@RequestBody Categories categories){
    Optional <Categories> updateCateg = repository.findById(id);
    updateCateg.get().setName(categories.getName());
    return repository.save(categories);
    }

}

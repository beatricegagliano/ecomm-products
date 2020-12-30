package dsbd2020.proj.ecommproducts.controller;

import dsbd2020.proj.ecommproducts.categories.Categories;
import dsbd2020.proj.ecommproducts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class CategoriesController {
    @Autowired
    CategoryService service;

    @PostMapping(path= "/categories")
    public @ResponseBody
    Categories addcategories (@RequestBody Categories categories){
        return service.addcategories(categories);
    }

    @GetMapping(path="/categories/{id}")
    public @ResponseBody
    Categories getCategories (@PathVariable Integer id) {
        return service.getCategories(id);
    }

  /*  @GetMapping(path="/categories")
    public @ResponseBody
    Iterable <Categories> getCategoriesAll () {
        return repository.findAll();
    }
  */
  @GetMapping(value="/categories")
  public ResponseEntity<List<Categories>> getAllCategories(
          @RequestParam(defaultValue = "0") Integer perPage,
          @RequestParam(defaultValue = "10") Integer page)
  {
      List<Categories> list = service.getAllCategories(perPage,page);

      return new ResponseEntity<List<Categories>>(list, new HttpHeaders(), HttpStatus.OK);
  }



    @PutMapping(path="/categories/{id}")
    public @ResponseBody
    Categories updateCateg (@PathVariable Integer id,@RequestBody Categories categories){
    return service.updateCateg(id,categories);
    }

    @DeleteMapping(path="/categories/{id}")
    public @ResponseBody
    String delete (@PathVariable Integer id) {
        service.deletebyid(id);
        return "category deleted";
    }


}

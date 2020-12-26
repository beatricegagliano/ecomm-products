package dsbd2020.proj.ecommproducts.controller;


import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller

public class ProductController {
    
    @Autowired
    ProductsRepository repository;

    @RequestMapping(value= "/products",method= RequestMethod.POST)
    public @ResponseBody
    Products addProducts (@RequestBody Products products){
        return repository.save(products);
    }

    @RequestMapping(value= "/products/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Optional<Products> getProducts(@PathVariable Integer id){
        return repository.findById(id);
    }

    @RequestMapping(path= "/products/{id}",method= RequestMethod.PUT)
    public @ResponseBody
     Products updateProducts (@RequestBody Products products, @PathVariable Integer id){
        return repository.save(products);
    }

    @RequestMapping(value= "/products",method= RequestMethod.GET)
    public @ResponseBody
    Iterable<Products> getProductsAll(){
        return repository.findAll();
    }
}
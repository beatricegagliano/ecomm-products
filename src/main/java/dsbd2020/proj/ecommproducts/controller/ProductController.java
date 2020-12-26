package dsbd2020.proj.ecommproducts.controller;

import dsbd2020.proj.ecommproducts.products.Products;
import dsbd2020.proj.ecommproducts.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller

public class ProductController {
    
    @Autowired
    ProductsService service;

    @RequestMapping(value= "/products",method= RequestMethod.POST)
    public @ResponseBody
    Products addProducts (@RequestBody Products products){
        return service.addProducts(products);
    }

    @RequestMapping(value= "/products/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Products getProducts(@PathVariable Integer id){
        return service.getProducts(id);
    }

    @RequestMapping(path= "/products/{id}",method= RequestMethod.PUT)
    public @ResponseBody
     Products updateProducts (@RequestBody Products products, @PathVariable Integer id){
        return service.updateProducts(products,id);
    }

    @RequestMapping(value= "/products",method= RequestMethod.GET)
    public @ResponseBody
    Iterable<Products> getProductsAll(){
        return service.getProductsAll();
    }
}
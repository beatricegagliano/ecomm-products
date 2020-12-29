package dsbd2020.proj.ecommproducts.controller;

import dsbd2020.proj.ecommproducts.products.Products;
import dsbd2020.proj.ecommproducts.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class ProductController {

    @Autowired
    ProductsService service;


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    Products addProducts(@RequestBody Products products) {
        return service.addProducts(products);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Products getProducts(@PathVariable Integer id) { return service.getProducts(id); }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Products> getProductsAll() { return service.getProductsAll(); }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Products updateProducts(@PathVariable Integer id, @RequestBody Products products) {
        service.getProducts(id);
        return service.updateProducts(products);

    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody
    String ping() {
        return "{"
                + "'serviceStatus':'UP',"
                + "'dbStatus':'UP'"
                +
                '}';
    }

    @DeleteMapping(path="/products/{id}")
    public @ResponseBody
    String delete (@PathVariable Integer id) {
        service.deletebyid(id);
        return "product deleted";
    }



/*
    @RequestMapping(value= "/products",method= RequestMethod.GET)
    public ResponseEntity<List<Products>> getProductsAll(
            @RequestParam(defaultValue = "10") Integer per_page,
            @RequestParam(defaultValue = "2") Integer page
            )
    {
        List<Products> list = service.getProductsAll(per_page, page);

        return new ResponseEntity<List<Products>>(list, new HttpHeaders(), HttpStatus.OK);
    }

*/






}
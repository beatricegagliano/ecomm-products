package dsbd2020.proj.ecommproducts.controller;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.ProductUpdateRequest;
import dsbd2020.proj.ecommproducts.products.Products;
import dsbd2020.proj.ecommproducts.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@Controller

public class ProductController {

    @Autowired
    ProductsService service;
/*
    @Value("${kafkaTopic}")
    private String topic;
    @Value("${kafkaTopic1}")
    private String topic1;
    @Value ("${kafkaTopic2}")
    private String topic2;

    @Autowired
    private KafkaTemplate <String,String> template;

    public void sendMessage(String msg) {
        template.send(topic,msg);
    }
    */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    Products addProducts(@RequestBody Products products) {
        return service.addProducts(products);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Products getProducts(@PathVariable Integer id) {  return service.getProducts(id); }

/*
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Products> getProductsAll() { return service.getProductsAll(); }
*/

    @GetMapping(value="/products")
    public ResponseEntity<List<Products>> getAllProducts(
            @RequestParam(defaultValue = "0") Integer perPage,
            @RequestParam(defaultValue = "10") Integer page)
    {
        List<Products> list = service.getAllProducts(perPage,page);

        return new ResponseEntity<List<Products>>(list, new HttpHeaders(), HttpStatus.OK);
    }




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










}
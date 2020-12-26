package dsbd2020.proj.ecommproducts.service;

import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ProductsService {
    @Autowired
    ProductsRepository repository;


    public Products addProducts (Products products){
        return repository.save(products);
    }


    public Products getProducts(Integer id){
        return repository.findById(id).get();
    }

    public Products updateProducts (Products products, Integer id){
        return repository.save(products);
    }


    public Iterable<Products> getProductsAll(){
        return repository.findAll();
    }

}

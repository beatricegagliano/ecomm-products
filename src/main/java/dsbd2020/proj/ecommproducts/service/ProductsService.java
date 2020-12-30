package dsbd2020.proj.ecommproducts.service;

import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProductsService  {
    @Autowired
    ProductsRepository repository;


    public Products addProducts (Products products){
        return repository.save(products);
    }


    public Products getProducts(Integer id){ return repository.findById(id).get(); }

    public Products updateProducts (Products products){
        products.setBrand(products.getBrand());
        products.setDescription(products.getDescription());
        products.setModel(products.getModel());
        products.setPrice(products.getPrice());
        products.setQuantity(products.getQuantity());
        return repository.save(products);
    }

    /*
   public Iterable<Products> getProductsAll(){
        return repository.findAll();
    }
*/
    public List<Products> getAllProducts(Integer perPage, Integer page)
    {
        Pageable paging = PageRequest.of(perPage,page);

        Page<Products> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Products>();
        }
    }

    public String deletebyid (Integer id) {
        repository.deleteById(id);
        return "cancellato";
    }




}

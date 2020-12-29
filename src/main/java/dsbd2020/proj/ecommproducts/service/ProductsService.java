package dsbd2020.proj.ecommproducts.service;

import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public Iterable<Products> getProductsAll(){
        return repository.findAll();
    }

    public String deletebyid (Integer id) {
        repository.deleteById(id);
        return "cancellato";
    }


/*
    public List <Products> getProductsAll(Integer per_page, Integer page) {
        per_page=per_page*(page-1);
        Pageable paging = PageRequest.of(per_page, page);

        Page<Products> pagedResult = repository.findAll(paging);


        return pagedResult.getContent();

    }
*/


}

package dsbd2020.proj.ecommproducts.service;

import dsbd2020.proj.ecommproducts.data.OrderCompleted;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class ProductsService {
    @Autowired
    ProductsRepository repository;

    @Value("${kafkaTopic}")
    private String topicName;
    @Value("${kafkaTopic1}")
    private String topicName1;
    @Value ("${kafkaTopic2}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String,String> template;



    public void sendMessage(String msg) {
        template.send(topicName,msg);
    }

    public void sendMessage1(String msg) {
        template.send(topicName1,msg);
    }
    public void sendMessage2(String msg) {
        template.send(topicName2,msg);
    }





    public Products addProducts(Products products) {
        return repository.save(products);
    }


    public Products getProducts(Integer id) {
        return repository.findById(id).get();
    }

    public Products updateProducts(Products products) {
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
    public List<Products> getAllProducts(Integer perPage, Integer page) {
        Pageable paging = PageRequest.of(perPage, page);

        Page<Products> pagedResult = repository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Products>();
        }
    }

    public String deletebyid(Integer id) {
        repository.deleteById(id);
        return "cancellato";
    }



    public void updateQuantityPrice(OrderCompleted updateRequest) {
        double total = 0.0;
        int status = 0;
        for (Map.Entry<Integer, Integer> entry : updateRequest.getProducts().entrySet()) {
            Optional<Products> p = repository.findById(entry.getKey());
            total = total + (p.get().getPrice() * entry.getValue());
            if (p != null && p.get().getQuantity() >= entry.getValue() && total == updateRequest.getTotal()) {
                repository.save(p.get().setQuantity(p.get().getQuantity() - entry.getValue()));
                status = 0;
            } else {
                status = -3;
            }
            if (total != updateRequest.getTotal()) {
                status = -2;
            }
            if (p != null && p.get().getQuantity() <= entry.getValue()) {
                status = -1;
            }
        }
    }



}



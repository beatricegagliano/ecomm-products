package dsbd2020.proj.ecommproducts.service;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.OrderCompleted;
import dsbd2020.proj.ecommproducts.data.OrderValidation;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.exceptionhandler.ResourceNotFoundException;
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



    public void sendMessage(String topic,String key,String value) {
        template.send(topicName,key,value);
    }

    public void sendMessage1(String topic,String key,String value) {
        template.send(topicName1,key,value);
    }
    public void sendMessage2(String topic,String key,String value) {
        template.send(topicName2,key,value);
    }





    public Products addProducts(Products products) {
        return repository.save(products);
    }


    public Products getProducts(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

    }

    public Products updateProducts(Products products) {
        products.setBrand(products.getBrand());
        products.setDescription(products.getDescription());
        products.setModel(products.getModel());
        products.setPrice(products.getPrice());
        products.setQuantity(products.getQuantity());
        return repository.save(products);
    }


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


    public void updateQuantityPrice(OrderCompleted orderC) {
        double total = 0.0;
        for (Map.Entry<Integer, Integer> entry : orderC.getProducts().entrySet()) {
            Optional<Products> p = repository.findById(entry.getKey());
            total = total + (p.get().getPrice() * entry.getValue());
            if (p != null && p.get().getQuantity() >= entry.getValue() && total == orderC.getTotal()) {
                repository.save(p.get().setQuantity(p.get().getQuantity() - entry.getValue()));
                OrderValidation order = new OrderValidation()
                .setTimestamp(System.currentTimeMillis())
                .setStatus(0)
                .setOrderId(orderC.getOrderId())
                .setExtraArgs(null);
                String value = new Gson().toJson(order);
                sendMessage(topicName,"order_validation",value);
                sendMessage1(topicName1,"order_validation",value);
            } if (p != null && p.get().getQuantity() <= entry.getValue() && total != orderC.getTotal()) {
                OrderValidation order = new OrderValidation()
                        .setTimestamp(System.currentTimeMillis())
                        .setStatus(-3)
                        .setOrderId(orderC.getOrderId())
                        .setExtraArgs(null);
                String value = new Gson().toJson(order);
                sendMessage(topicName,"order_validation",value);
                sendMessage1(topicName1,"order_validation",value);
                sendMessage2(topicName2,"order_validation",value);
            }
            if (total != orderC.getTotal()) {
                OrderValidation order = new OrderValidation()
                        .setTimestamp(System.currentTimeMillis())
                        .setStatus(-2)
                        .setOrderId(orderC.getOrderId())
                        .setExtraArgs(null);
                String value = new Gson().toJson(order);
                sendMessage(topicName,"order_validation",value);
                sendMessage1(topicName1,"order_validation",value);
                sendMessage2(topicName2,"order_validation",value);
            }
            if (p != null && p.get().getQuantity() <= entry.getValue()) {
                Map <Integer, Integer> unvailable = new HashMap<>();
                unvailable.put(entry.getKey(), entry.getValue());
                OrderValidation order = new OrderValidation()
                        .setTimestamp(System.currentTimeMillis())
                        .setStatus(-1)
                        .setOrderId(orderC.getOrderId())
                        .setExtraArgs(unvailable);
                String value = new Gson().toJson(order);
                sendMessage(topicName,"order_validation",value);
                sendMessage1(topicName1,"order_validation",value);
            }
        }
    }


}



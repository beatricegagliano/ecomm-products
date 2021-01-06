package dsbd2020.proj.ecommproducts.kafka;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.ProductUpdateRequest;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class KafkaConsumerProducts {

    @Autowired
    ProductsRepository repository;

    @KafkaListener(topics = "${kafkaTopic}", groupId = "${kafkaGroup}")

    public void listenProductTopic(String message) {

        if (message != null) {
            ProductUpdateRequest updateRequest = new Gson().fromJson(message, ProductUpdateRequest.class);
    Map<Integer,Integer> lproducts= new HashMap<>();
            int status =0;
    double total = 0.0;

    for (Map.Entry <Integer,Integer> entry : lproducts.entrySet()){
        Optional<Products> product = repository.findByIdAndQuantityGreaterThanEqual(entry.getKey(),entry.getValue());
        if (!product.isPresent()) {
            lproducts.put(entry.getKey(), entry.getValue()); }
        else {
           total = total + (product.get().getPrice() * product.get().getQuantity());
            }
        }

    if (lproducts.isEmpty() && total != updateRequest.getTotal())
          status  = -3;
    else if (lproducts.isEmpty())
           status = -1;
    else if (total!= updateRequest.getTotal())
           status = -2;
    else {
        status = 0;

        for (Map.Entry <Integer,Integer> entry : lproducts.entrySet()){
         Optional <Products>  p = repository.findById(entry.getKey());
         repository.save(p.get().setQuantity(p.get().getQuantity()- entry.getValue()));
        }
    }
    }
        }


    }






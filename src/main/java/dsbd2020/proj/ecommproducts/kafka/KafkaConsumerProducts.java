package dsbd2020.proj.ecommproducts.kafka;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.ProductUpdateRequest;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class KafkaConsumerProducts {

    @Autowired
    ProductsRepository repository;

    @KafkaListener(topics = "${kafkaTopic}", groupId = "${kafkaGroup}")

    public void listenProductTopic(String message) {
        if (message != null) {
            ProductUpdateRequest updateRequest = new Gson().fromJson(message, ProductUpdateRequest.class);
            Optional<Products> product = repository.findById(updateRequest.getProducts().getId());
            if (product.isPresent()) {
                Products p = product.get();
                p.setQuantity(p.getQuantity()-updateRequest.getProducts().getQuantity());
                repository.save(p);
            }
        }


    }


}

package dsbd2020.proj.ecommproducts.kafka;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.ProductUpdateRequest;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import dsbd2020.proj.ecommproducts.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
public class KafkaConsumerProducts {

    @Autowired
    ProductsService service;

    @KafkaListener(topics = "${kafkaTopic}", groupId = "${kafkaGroup}")

    public void listenProductTopic(String message) {

        if (message != null) {
            ProductUpdateRequest updateRequest = new Gson().fromJson(message, ProductUpdateRequest.class);
            service.updateQuantityPrice(updateRequest);

        }


    }
}






package dsbd2020.proj.ecommproducts.kafka;

import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.ProductUpdateRequest;
import dsbd2020.proj.ecommproducts.data.ProductsRepository;
import dsbd2020.proj.ecommproducts.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class KafkaConsumerProducts {

    @Autowired
    ProductsRepository repository;

    @KafkaListener(topics = "${kafkaTopic}", groupId = "${kafkaGroup}")

    public void listenProductTopic(String message) {
        if (message != null) {
            ProductUpdateRequest updateRequest = new Gson().fromJson(message, ProductUpdateRequest.class);
            List<Products> lproducts = new ArrayList<>();
            for (Products i : lproducts) {
                Optional<Products> product = repository.findById(updateRequest.getProducts().getId());
                if (product.isPresent()) {
                    Products p = product.get();
                    p.setQuantity(p.getQuantity() - updateRequest.getProducts().getQuantity());
                    repository.save(p);
                }
                System.out.println(i);
                if (product.isPresent()) {
                    Products p = product.get();
                    double s = sum (p.getPrice() * p.getQuantity());
                    if (s == updateRequest.getTotal())
                    {
                      System.out.println("Verifica ok\n ");
                    }

                }
            }

        }


    }

    private double sum(double v) {
        double s=0;
        s = s + v;
        return s;
    }


}

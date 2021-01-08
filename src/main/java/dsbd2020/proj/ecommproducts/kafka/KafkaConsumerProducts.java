package dsbd2020.proj.ecommproducts.kafka;
import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.OrderCompleted;
import dsbd2020.proj.ecommproducts.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumerProducts {

    @Autowired
    ProductsService service;

    @KafkaListener(topics = "${kafkaTopic}", groupId = "${kafkaGroup}")

    public void listenProductTopic(String message) {

        if (message != null) {
            OrderCompleted updateRequest = new Gson().fromJson(message, OrderCompleted.class);
            service.updateQuantityPrice(updateRequest);













        }


    }
}






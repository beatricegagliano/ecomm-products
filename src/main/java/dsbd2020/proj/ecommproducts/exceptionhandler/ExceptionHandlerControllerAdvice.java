package dsbd2020.proj.ecommproducts.exceptionhandler;


import com.google.gson.Gson;
import dsbd2020.proj.ecommproducts.data.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import javax.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @Value("${kafkaTopic2}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String,String> template;

    public void sendMessage3(String topic,String key,String value) {
        template.send(topicName2,key,value);
    }





    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException exception,
                                                         HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        String body= "Products not found";

        MessageError MesError = new MessageError()
                .setTimestamp(System.currentTimeMillis())
                .setSourceIp(request.getRemoteAddr())
                .setService("products")
                .setRequest(request.getRequestURI() + "|" + request.getMethod())
                .setError("Status Code 404");
        String value = new Gson().toJson(MesError);
        sendMessage3(topicName2,"http_errors",value);


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);





    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleException(Exception exception,
                                      HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        String body= "body wrong or empty";

        MessageError MesError = new MessageError()
                .setTimestamp(System.currentTimeMillis())
                .setSourceIp(request.getRemoteAddr())
                .setService("products")
                .setRequest(request.getRequestURI() + "|" + request.getMethod())
                .setError("Status Code 400");
        String value = new Gson().toJson(MesError);
        sendMessage3(topicName2,"http_errors",value);


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }


    }














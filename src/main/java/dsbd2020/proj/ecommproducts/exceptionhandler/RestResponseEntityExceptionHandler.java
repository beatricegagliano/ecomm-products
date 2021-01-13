package dsbd2020.proj.ecommproducts.exceptionhandler;


import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.logging.Logger;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductsNotFounds.class)
    public ResponseEntity<Object> handleProductsNotFounds(
            ProductsNotFounds ex, WebRequest request) {
        String bodyOfResponse = "Product not found";
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        return "request has empty body  or exception occured";
    }



}

















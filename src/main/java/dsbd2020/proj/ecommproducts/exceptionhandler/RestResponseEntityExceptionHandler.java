package dsbd2020.proj.ecommproducts.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductsNotFounds.class)
    public ResponseEntity<Object> handleProductsNotFounds(
            ProductsNotFounds ex, WebRequest request) {
        String bodyOfResponse = "Product not found";
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(Throwable.class)
    public @ResponseBody ResponseEntity<ErrorResponse> handleDefaultException(Throwable ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex);
        errorResponse.setMessage("request has empty body  or exception occured");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }



}










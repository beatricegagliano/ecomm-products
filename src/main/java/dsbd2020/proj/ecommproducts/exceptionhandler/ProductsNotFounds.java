package dsbd2020.proj.ecommproducts.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductsNotFounds extends RuntimeException{
    public ProductsNotFounds(Integer id) {
        super(String.format("Product with Id %d not found", id));
    }
}

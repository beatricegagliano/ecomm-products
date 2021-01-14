package dsbd2020.proj.ecommproducts.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Integer id) {
        super(String.format("Products with Id %d non found",id));
    }


}

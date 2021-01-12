package dsbd2020.proj.ecommproducts.exceptionhandler;

public class ProductsNotFounds extends RuntimeException{
    public ProductsNotFounds(Integer id) {
        super(String.format("Product with Id %d not found", id));
    }
}
